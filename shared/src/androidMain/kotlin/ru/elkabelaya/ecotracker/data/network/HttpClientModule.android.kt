package ru.elkabelaya.ecotracker.data.network

import io.ktor.client.*
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*


actual fun httpClientEngineFactory(): HttpClientEngineFactory<HttpClientEngineConfig> = Android