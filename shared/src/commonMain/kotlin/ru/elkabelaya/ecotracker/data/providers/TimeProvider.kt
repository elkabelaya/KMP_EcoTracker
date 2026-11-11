package ru.elkabelaya.ecotracker.data.providers

interface TimeProvider {
    fun currentTimeMillis(): Long
}
