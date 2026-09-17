package ru.elkabelaya.ecotracker.di

import app.cash.sqldelight.db.SqlDriver
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import ru.elkabelaya.ecotracker.data.providers.TimeProvider
import ru.elkabelaya.ecotracker.data.providers.TimeProviderImpl
import ru.elkabelaya.ecotracker.data.repository.HabitRepositoryImpl
import ru.elkabelaya.ecotracker.db.EcoTrackDatabase
import ru.elkabelaya.ecotracker.domain.repository.HabitRepository
import ru.elkabelaya.ecotracker.domain.usecase.AddHabitUseCase
import ru.elkabelaya.ecotracker.domain.usecase.GetHabitsUseCase
import ru.elkabelaya.ecotracker.ui.viewmodels.HabitViewModel

fun databaseModule(sqlDriver: SqlDriver)= module {
    single<SqlDriver> { sqlDriver }
}

val commonModule = module {
    single { EcoTrackDatabase(get()) }
    single<TimeProvider> {
        TimeProviderImpl()
    }

    single<HabitRepository> {
        HabitRepositoryImpl(get(), get())
    }
    // UseCases
    factory { AddHabitUseCase(get()) }
    factory { GetHabitsUseCase(get()) }

    // ViewModels
    viewModel { HabitViewModel(get(), get()) }
}

// Ожидаем платформенный модуль
expect val platformModule: Module

fun initKoin(sqlDriver: SqlDriver, config: KoinAppDeclaration? = null) {
    startKoin {
        // Позволяет платформе передать свой Context, если нужно
        config?.invoke(this)
        // Подключаем модули
        modules(
            databaseModule(sqlDriver),
            platformModule,
            commonModule
        )
    }
}