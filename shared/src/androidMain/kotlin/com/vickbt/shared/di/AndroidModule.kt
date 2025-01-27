package com.vickbt.shared.di

import android.content.Context
import com.google.android.gms.location.LocationServices
import com.vickbt.shared.domain.utils.DatabaseFactory
import com.vickbt.shared.domain.utils.LocationService
import org.koin.dsl.module

actual val platformModule = module {

    /**Creates a fused location client used to create an instance of [LocationServices]*/
    single {
        val fusedLocationClient =
            LocationServices.getFusedLocationProviderClient(get<Context>())
        LocationService(context = get(), locationClient = fusedLocationClient)
    }

    /**Create a singleton instance of the database [AppDatabase]*/
    single { DatabaseFactory(context = get()).createDatabase() }
}
