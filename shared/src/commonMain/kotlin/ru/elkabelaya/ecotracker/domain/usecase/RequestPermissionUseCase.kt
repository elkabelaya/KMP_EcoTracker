import ru.elkabelaya.ecotracker.domain.repository.NotificationRepository

class RequestPermissionUseCase(
    private val repository: NotificationRepository
) {
    suspend operator fun invoke(): Result<Boolean> {
        return repository.requestPermission()
    }

    private companion object {
        const val MAX_LENGTH = 100
    }
}
