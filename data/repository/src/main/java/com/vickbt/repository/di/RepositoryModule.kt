package com.vickbt.repository.di

import com.vickbt.domain.repositories.WeatherRepository
import com.vickbt.repository.datasources.WeatherDataSource
import org.koin.dsl.module

val repositoryModule = module {

    single<WeatherRepository> { WeatherDataSource(weatherApiService = get()) }

}
