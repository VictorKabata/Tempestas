package com.vickbt.shared.data.cache

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import com.vickbt.shared.data.cache.daos.WeatherDao
import com.vickbt.shared.data.cache.entities.CityEntity
import com.vickbt.shared.data.cache.entities.CoordinatesEntity
import com.vickbt.shared.data.cache.entities.MainEntity
import com.vickbt.shared.data.cache.entities.WeatherDataEntity
import com.vickbt.shared.data.cache.entities.WeatherEntity
import com.vickbt.shared.data.cache.entities.WeatherItemEntity
import com.vickbt.shared.data.cache.entities.WindEntity

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}

@Database(
    entities = [CityEntity::class, CoordinatesEntity::class, MainEntity::class, WeatherDataEntity::class, WeatherEntity::class, WeatherItemEntity::class, WindEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(WeatherTypeConverters::class)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}
