package ru.elkabelaya.ecotracker.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.worker.WebWorkerDriver
import app.cash.sqldelight.driver.worker.createDefaultWebWorkerDriver
import org.koin.core.module.Module
import org.koin.dsl.module
import org.w3c.dom.Worker
import ru.elkabelaya.ecotracker.db.EcoTrackDatabase

@OptIn(ExperimentalWasmJsInterop::class)
actual val platformModule: Module = module {

}