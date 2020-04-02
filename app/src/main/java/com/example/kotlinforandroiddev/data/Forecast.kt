package com.example.kotlinforandroiddev.data

import com.squareup.moshi.Json

data class Forecast(
    val clouds: Int,
    val deg: Int,
    val dt: Long,
    @Json(name = "feels_like")
    val feelsLike: FeelsLike,
    val humidity: Int,
    val pressure: Int,
    val rain: Double?,
    val speed: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: Temp,
    val weather: List<Weather>
)