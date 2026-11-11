package ru.elkabelaya.ecotracker.data.network

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.js.Js

actual fun httpClientEngineFactory(): HttpClientEngineFactory<HttpClientEngineConfig> = Js
