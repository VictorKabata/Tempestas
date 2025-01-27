package com.vickbt.shared.data.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vickbt.shared.data.cache.entities.WeatherDataEntity

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherData(weatherItems: List<WeatherDataEntity>)

    @Query("SELECT * FROM weather_data_table")
    suspend fun getWeatherData(): List<WeatherDataEntity>
}
