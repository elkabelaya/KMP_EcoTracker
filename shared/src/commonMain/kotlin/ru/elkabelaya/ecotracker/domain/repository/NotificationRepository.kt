package ru.elkabelaya.ecotracker.domain.repository

interface NotificationRepository {
    suspend fun requestPermission(): Result<Boolean>
    suspend fun sendNotification(title: String, body: String, delay: Double?): Result<Unit>
    suspend fun isPermissionGranted(): Boolean
}
