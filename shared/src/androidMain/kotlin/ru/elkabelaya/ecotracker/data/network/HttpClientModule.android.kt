package ru.elkabelaya.ecotracker.data.network

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.android.Android

actual fun httpClientEngineFactory(): HttpClientEngineFactory<HttpClientEngineConfig> = Android
