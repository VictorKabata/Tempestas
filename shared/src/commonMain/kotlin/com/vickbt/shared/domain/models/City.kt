package com.vickbt.shared.domain.models

data class City(
    val id: Int,
    val name: String,
    val coordinates: Coordinates,
    val country: String,
    val population: Int,
    val timezone: Int,
    val sunrise: Long,
    val sunset: Long
)
