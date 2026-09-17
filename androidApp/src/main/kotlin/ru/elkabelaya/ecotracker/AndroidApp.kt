package ru.elkabelaya.ecotracker

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.elkabelaya.ecotracker.di.createDriver
import ru.elkabelaya.ecotracker.di.initKoin

class AndroidApp: Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin(createDriver(this)) {
            androidContext(this@AndroidApp)
        }

    }
}