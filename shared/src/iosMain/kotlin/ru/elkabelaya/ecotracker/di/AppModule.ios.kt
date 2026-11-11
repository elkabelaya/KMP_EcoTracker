package ru.elkabelaya.ecotracker.di

import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.elkabelaya.ecotracker.data.db.Database
import ru.elkabelaya.ecotracker.db.EcoTrackDatabase

actual val platformModule: Module = module {
}

fun createDriver(): SqlDriver {
    return NativeSqliteDriver(
        schema = EcoTrackDatabase.Schema.synchronous(),
        name = Database.FILENAME
    )
}

fun initKoinIOS() {
    initKoin(createDriver())
}
