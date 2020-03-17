package com.example.kotlinforandroiddev.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://api.openweathermap.org/data/2.5/"
private const val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"

private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

interface WeatherApiService {
    @GET("forecast/daily?mode=json&units=metric&cnt=7&APPID=$APP_ID")
    fun getDailyWeather(@Query("q") zipCode: String):
            Call<ForecastResult>
}

object WeatherApi {
    val retrofitService: WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java)
    }
}