package com.vickbt.shared.di

import android.content.Context
import com.google.android.gms.location.LocationServices
import com.vickbt.shared.domain.utils.LocationService
import org.koin.dsl.module

val androidModule = module {

    /**Creates a fused location client used to create an instance of [LocationServices]*/
    single {
        val fusedLocationClient =
            LocationServices.getFusedLocationProviderClient(get<Context>())
        LocationService(context = get(), locationClient = fusedLocationClient)
    }
}
