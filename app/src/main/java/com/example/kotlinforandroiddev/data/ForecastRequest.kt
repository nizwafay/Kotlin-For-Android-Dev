package com.example.kotlinforandroiddev.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://api.openweathermap.org/data/2.5/"
private const val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

interface WeatherApiService {
    @GET("forecast/daily?mode=json&units=metric&cnt=7&APPID=$APP_ID")
    suspend fun getDailyWeather(@Query("zip") zipCode: String): ForecastResult
}

object WeatherApi {
    val service: WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java)
    }
}