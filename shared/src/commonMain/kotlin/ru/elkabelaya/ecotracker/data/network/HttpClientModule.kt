package ru.elkabelaya.ecotracker.data.network

import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.encodedPath
import io.ktor.serialization.kotlinx.json.json

class TokenStorageImpl: TokenStorage {
    override fun getAccessToken(): String {
        TODO("Not yet implemented")
    }

    override fun getRefreshToken(): String {
        TODO("Not yet implemented")
    }

    override fun saveTokens(accessToken: String, refreshToken: String) {
        TODO("Not yet implemented")
    }

    override fun clearTokens() {
        TODO("Not yet implemented")
    }

}
interface TokenStorage {
    fun getAccessToken(): String
    fun getRefreshToken(): String
    fun saveTokens(accessToken: String, refreshToken: String)
    fun  clearTokens()
}

fun createHttpClient(
    baseURL: String,
    tokenStorage: TokenStorage,
    onLogOut: () -> Unit
): HttpClient =  HttpClient(httpClientEngineFactory()) {
    install(ContentNegotiation) {
        json()
    }

    install(Logging) {
        level = LogLevel.BODY
    }

    defaultRequest {
        url(baseURL)
        header("Content-Type", "application/json")
    }
//TODO add auth process
//    install(Auth) {
//        bearer {
//            loadTokens {
//                BearerTokens(tokenStorage.getAccessToken(), tokenStorage.getRefreshToken())
//            }
//
//            refreshTokens {
//                val currentRefreshToken = oldTokens?.refreshToken ?: return@refreshTokens null
//
//                try {
//                    val newTokensDto = client.post(baseURL) {
//                        markAsRefreshTokenRequest() // Предотвращает рекурсию и зацикливание
//                        //setBody(RefreshRequest(currentRefreshToken))
//                    }//.body<TokenResponse>()
//
//                    // Сохраняем новые полученные токены в локальное хранилище
//                    //tokenStorage.saveTokens(newTokensDto.accessToken, newTokensDto.refreshToken)
//
//                    // Возвращаем новые токены плагину. Ktor автоматически повторит упавший запрос с новым Access Token!
//                    BearerTokens(
//                        accessToken = "",//newTokensDto.accessToken,
//                        refreshToken = ""//newTokensDto.refreshToken
//                    )
//                } catch (e: Exception) {
//                    // Если рефреш-токен тоже протух или сервер ответил ошибкой —
//                    // очищаем хранилище и отправляем пользователя на экран логина
//                    tokenStorage.clearTokens()
//                    onLogOut()
//
//                    null // Возврат null сообщает Ktor, что обновить токены не удалось
//                }
//            }
//
//            //для каких эндпоинтов НЕ нужно вообще пытаться слать или обновлять токены
//            sendWithoutRequest { request ->
//                request.url.encodedPath.contains("/auth/login") ||
//                        request.url.encodedPath.contains("/auth/register")
//            }
//        }
//    }
}

expect fun httpClientEngineFactory(): HttpClientEngineFactory<HttpClientEngineConfig>