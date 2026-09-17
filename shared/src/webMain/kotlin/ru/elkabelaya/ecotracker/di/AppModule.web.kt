package ru.elkabelaya.ecotracker.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.worker.WebWorkerDriver
import app.cash.sqldelight.driver.worker.createDefaultWebWorkerDriver
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.dsl.module
import ru.elkabelaya.ecotracker.db.EcoTrackDatabase
import kotlin.js.js

suspend fun createDriver(): SqlDriver {
        val driver = createDefaultWebWorkerDriver()
        EcoTrackDatabase.Schema.create(driver).await()
        return driver
}
suspend fun initKoinWeb() {
        initKoin(createDriver())
}