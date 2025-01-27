package com.vickbt.shared.data.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vickbt.shared.data.cache.entities.WeatherDataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveWeatherData(weatherData: WeatherDataEntity)

    @Query("SELECT * FROM weather_data_table")
    fun getWeatherData(): Flow<WeatherDataEntity?>?
}
