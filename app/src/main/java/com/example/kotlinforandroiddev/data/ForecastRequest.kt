package com.example.kotlinforandroiddev.data

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://api.openweathermap.org/"

private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

interface WeatherApiService {
    @GET("data/2.5/forecast/daily?" +
            "APPID=15646a06818f61f7b8d7823ca833e1ce&zip=94043&mode=json&units=metric&cnt=7")
    suspend fun getDailyWeather(): String
}

object WeatherApi {
    val service: WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java)
    }
}