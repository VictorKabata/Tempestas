@file:OptIn(ExperimentalSerializationApi::class)

package com.vickbt.shared.di

import com.vickbt.shared.BuildKonfig
import com.vickbt.shared.data.network.WeatherApiServiceImpl
import com.vickbt.shared.data.network.services.WeatherApiService
import com.vickbt.shared.data.repository.datasource.WeatherDataSource
import com.vickbt.shared.domain.repository.WeatherRepository
import com.vickbt.shared.domain.utils.Constants.BASE_URL
import com.vickbt.shared.domain.utils.Constants.URL_PATH
import com.vickbt.shared.domain.utils.LocationService
import com.vickbt.shared.ui.screens.home.HomeViewModel
import com.vickbt.shared.ui.screens.search.SearchViewModel
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.addDefaultResponseValidation
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val sharedModule: Module = module {

    /**Create a singleton instance of ktor client*/
    single {
        HttpClient(CIO) {
            expectSuccess = true
            addDefaultResponseValidation()

            // Append api key on all requests
            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = BASE_URL
                    path(URL_PATH)
                    parameters.append(
                        "APPID",
                        BuildKonfig.API_KEY
                    )
                }
            }

            install(Logging) {
                level = LogLevel.HEADERS
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.i(tag = "Http Client", message = message)
                    }
                }
            }.also {
                Napier.base(DebugAntilog())
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        explicitNulls = false
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }

    /**Create a singleton of [WeatherApiService]*/
    single<WeatherApiService> { WeatherApiServiceImpl(weatherApiClient = get()) }

    single<WeatherRepository> {
        WeatherDataSource(weatherApiService = get(), locationService = get<LocationService>())
    }

    viewModelOf(::HomeViewModel)
    viewModelOf(::SearchViewModel)
}

expect val platformModule: Module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(platformModule, sharedModule)
    }
