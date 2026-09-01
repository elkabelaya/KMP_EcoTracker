package ru.elkabelaya.ecotracker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform