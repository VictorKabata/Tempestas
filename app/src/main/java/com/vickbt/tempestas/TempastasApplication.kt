package com.vickbt.tempestas

import android.app.Application
import com.vickbt.shared.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class TempastasApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(androidContext = this@TempastasApplication)
        }
    }
}
