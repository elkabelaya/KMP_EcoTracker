package ru.elkabelaya.ecotracker.data.repository

import kotlinx.coroutines.suspendCancellableCoroutine
import platform.Foundation.NSUUID
import platform.UserNotifications.UNAuthorizationOptionAlert
import platform.UserNotifications.UNAuthorizationOptionBadge
import platform.UserNotifications.UNAuthorizationOptionSound
import platform.UserNotifications.UNAuthorizationStatusAuthorized
import platform.UserNotifications.UNAuthorizationStatusEphemeral
import platform.UserNotifications.UNAuthorizationStatusProvisional
import platform.UserNotifications.UNMutableNotificationContent
import platform.UserNotifications.UNNotificationRequest
import platform.UserNotifications.UNNotificationSound
import platform.UserNotifications.UNTimeIntervalNotificationTrigger
import platform.UserNotifications.UNUserNotificationCenter
import ru.elkabelaya.ecotracker.domain.repository.NotificationRepository

actual fun getNotificationRepository(): NotificationRepository = AppleNotificationRepository()

private class AppleNotificationRepository(
    val center: UNUserNotificationCenter = UNUserNotificationCenter.currentNotificationCenter()
) : NotificationRepository {
    override suspend fun requestPermission(): Result<Boolean> = suspendCancellableCoroutine { continuation ->
        val options = UNAuthorizationOptionAlert or UNAuthorizationOptionSound or UNAuthorizationOptionBadge

        center.requestAuthorizationWithOptions(options) { granted, error ->
            val result = if (error != null) {
                Result.failure(Exception(error.localizedDescription))
            } else {
                Result.success(granted)
            }
            continuation.resume(result) { _, _, _ -> }
        }
    }

    override suspend fun sendNotification(
        title: String,
        body: String,
        delay: Double?
    ): Result<Unit> = suspendCancellableCoroutine { continuation ->
        val content = UNMutableNotificationContent().apply {
            setTitle(title)
            setBody(body)
            setSound(UNNotificationSound.defaultSound())
        }

        val trigger = when (delay) {
            is Double -> UNTimeIntervalNotificationTrigger.triggerWithTimeInterval(delay, repeats = false)
            else -> null
        }

        val request = UNNotificationRequest.requestWithIdentifier(
            content = content,
            trigger = trigger,
            identifier = NSUUID().UUIDString
        )

        center.addNotificationRequest(request) { error ->
            val result = if (error != null) {
                Result.failure(Exception(error.localizedDescription))
            } else {
                Result.success(Unit)
            }

            continuation.resume(result) { _, _, _ -> }
        }
    }

    override suspend fun isPermissionGranted(): Boolean = suspendCancellableCoroutine { continuation ->
        center.getNotificationSettingsWithCompletionHandler { settings ->
            val status = settings?.authorizationStatus
            val isGranted = status == UNAuthorizationStatusAuthorized ||
                    status == UNAuthorizationStatusProvisional ||
                    status == UNAuthorizationStatusEphemeral

            continuation.resume(isGranted) { _, _, _ -> }
        }
    }
}
