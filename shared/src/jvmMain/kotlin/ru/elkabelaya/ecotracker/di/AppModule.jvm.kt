package ru.elkabelaya.ecotracker.di

import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.elkabelaya.ecotracker.data.db.Database
import ru.elkabelaya.ecotracker.db.EcoTrackDatabase
import java.io.File

actual val platformModule: Module = module {
}

fun createDriver(): SqlDriver {
    val databaseFile = File(System.getProperty("user.home"), Database.FILENAME)
    val driver = JdbcSqliteDriver("jdbc:sqlite:${databaseFile.absolutePath}")

    if (!databaseFile.exists()) {
        EcoTrackDatabase.Schema.synchronous().create(driver)
    }
    return driver
}