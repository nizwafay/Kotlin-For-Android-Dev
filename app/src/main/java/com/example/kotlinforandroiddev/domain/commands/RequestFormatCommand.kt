package com.example.kotlinforandroiddev.domain.commands

import com.example.kotlinforandroiddev.data.WeatherApi
import com.example.kotlinforandroiddev.domain.mappers.ForecastDataMapper
import com.example.kotlinforandroiddev.domain.model.ForecastList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {
    override suspend fun execute(): ForecastList {
        val dailyWeather = withContext(Dispatchers.IO) {
            WeatherApi.service.getDailyWeather(zipCode)
        }
        return ForecastDataMapper().convertFromDataModel(dailyWeather)
    }
}