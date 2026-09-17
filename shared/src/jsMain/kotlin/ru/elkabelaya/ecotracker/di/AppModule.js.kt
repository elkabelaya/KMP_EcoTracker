package ru.elkabelaya.ecotracker.di

import app.cash.sqldelight.db.SqlDriver
import org.koin.core.module.Module
import org.koin.dsl.module
import app.cash.sqldelight.driver.worker.createDefaultWebWorkerDriver
import ru.elkabelaya.ecotracker.db.EcoTrackDatabase


actual val platformModule: Module = module {
}