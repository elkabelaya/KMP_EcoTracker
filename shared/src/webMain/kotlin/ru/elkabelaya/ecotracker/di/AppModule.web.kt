package ru.elkabelaya.ecotracker.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.worker.createDefaultWebWorkerDriver
import ru.elkabelaya.ecotracker.db.EcoTrackDatabase

suspend fun createDriver(): SqlDriver {
    val driver = createDefaultWebWorkerDriver()
    EcoTrackDatabase.Schema.create(driver).await()
    return driver
}
suspend fun initKoinWeb() {
    initKoin(createDriver())
}
