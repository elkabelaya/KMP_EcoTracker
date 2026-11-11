package ru.elkabelaya.ecotracker.di

import app.cash.sqldelight.db.SqlDriver
import generated.gradle.buildkonfig.BuildKonfig
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import ru.elkabelaya.ecotracker.data.network.HabitApiRepositoryImpl
import ru.elkabelaya.ecotracker.data.network.TokenStorage
import ru.elkabelaya.ecotracker.data.network.TokenStorageImpl
import ru.elkabelaya.ecotracker.data.network.createHttpClient
import ru.elkabelaya.ecotracker.data.providers.TimeProvider
import ru.elkabelaya.ecotracker.data.providers.TimeProviderImpl
import ru.elkabelaya.ecotracker.data.repository.HabitRepositoryImpl
import ru.elkabelaya.ecotracker.data.repository.HabitSyncRepository
import ru.elkabelaya.ecotracker.db.EcoTrackDatabase
import ru.elkabelaya.ecotracker.domain.repository.HabitRepository
import ru.elkabelaya.ecotracker.domain.usecase.AddHabitUseCase
import ru.elkabelaya.ecotracker.domain.usecase.GetHabitsUseCase
import ru.elkabelaya.ecotracker.ui.viewmodels.AddHabitViewModel
import ru.elkabelaya.ecotracker.ui.viewmodels.HabitViewModel

fun databaseModule(sqlDriver: SqlDriver) = module {
    single<SqlDriver> { sqlDriver }
}

val networkModule = module {
    single<TokenStorage> { TokenStorageImpl() }

    single {
        createHttpClient(
            BuildKonfig.API_URL,
            get(),
            {
                // TODO
            }
        )
    }
}

val commonModule = module {
    single { EcoTrackDatabase(get()) }
    single<TimeProvider> {
        TimeProviderImpl()
    }

    single<HabitRepository> {
        HabitSyncRepository(
            HabitRepositoryImpl(get(), get()),
            HabitApiRepositoryImpl(get())
        )
    }
    // UseCases
    factory { AddHabitUseCase(get()) }
    factory { GetHabitsUseCase(get()) }

    // ViewModels
    viewModel { HabitViewModel(get()) }
    viewModel { AddHabitViewModel(get()) }
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
            networkModule,
            platformModule,
            commonModule
        )
    }
}
