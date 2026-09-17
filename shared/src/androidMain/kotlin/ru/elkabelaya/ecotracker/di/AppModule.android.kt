package ru.elkabelaya.ecotracker.di

import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.elkabelaya.ecotracker.data.db.Database
import ru.elkabelaya.ecotracker.db.EcoTrackDatabase


actual val platformModule: Module = module {

}

fun createDriver(context: Context): SqlDriver {
    return AndroidSqliteDriver(
        schema = EcoTrackDatabase.Schema.synchronous(),
        context = context,
        name = Database.FILENAME
    )
}