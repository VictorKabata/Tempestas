package com.vickbt.shared.domain.utils

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.vickbt.shared.data.cache.AppDatabase
import kotlinx.coroutines.Dispatchers

actual class DatabaseFactory(private val context: Context) {
    actual fun createDatabase(): AppDatabase {
        val appContext = context.applicationContext

        val dbFile = appContext.getDatabasePath("tempestas.db")
        return Room.databaseBuilder<AppDatabase>(
            context = appContext,
            name = dbFile.absolutePath
        ).setQueryCoroutineContext(Dispatchers.IO).fallbackToDestructiveMigration(true)
            .setDriver(BundledSQLiteDriver()).build()
    }
}
