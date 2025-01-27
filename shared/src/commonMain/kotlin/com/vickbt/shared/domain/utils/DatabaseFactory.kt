package com.vickbt.shared.domain.utils

import com.vickbt.shared.data.cache.AppDatabase

expect class DatabaseFactory {

    fun createDatabase(): AppDatabase
}
