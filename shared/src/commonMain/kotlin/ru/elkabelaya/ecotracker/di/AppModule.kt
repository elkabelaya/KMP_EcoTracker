package ru.elkabelaya.ecotracker.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import org.koin.mp.KoinPlatform.startKoin
import ru.elkabelaya.ecotracker.data.HabitRepositoryImpl
import ru.elkabelaya.ecotracker.di.platformModule
import ru.elkabelaya.ecotracker.domain.repository.HabitRepository
import ru.elkabelaya.ecotracker.domain.usecase.AddHabitUseCase
import ru.elkabelaya.ecotracker.ui.viewmodels.HabitViewModel

val commonModule = module {
    single<HabitRepository> {
        HabitRepositoryImpl()
    }
    // UseCases
    factory { AddHabitUseCase(get()) }

    // ViewModels
    viewModel { HabitViewModel(get()) }
}

// Ожидаем платформенный модуль
expect val platformModule: Module

// Собираем все вместе
val appModules = listOf(
    commonModule,
    platformModule
)

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        // Позволяет платформе передать свой Context, если нужно
        config?.invoke(this)
        // Подключаем модули
        modules(appModules)
    }
}