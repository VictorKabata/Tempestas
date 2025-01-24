package com.vickbt.tempestas

import android.app.Application
import org.koin.core.context.startKoin

class TempastasApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf())
        }
    }
}
