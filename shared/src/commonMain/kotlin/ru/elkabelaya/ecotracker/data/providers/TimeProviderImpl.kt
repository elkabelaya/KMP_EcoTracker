package ru.elkabelaya.ecotracker.data.providers

import kotlin.time.Clock

class TimeProviderImpl : TimeProvider {
    override fun currentTimeMillis(): Long {
        return Clock.System.now().toEpochMilliseconds()
    }
}
