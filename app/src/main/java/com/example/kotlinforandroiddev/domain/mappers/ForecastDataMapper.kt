package com.example.kotlinforandroiddev.domain.mappers

import com.example.kotlinforandroiddev.data.Forecast
import com.example.kotlinforandroiddev.data.ForecastResult
import com.example.kotlinforandroiddev.domain.model.ForecastList
import com.example.kotlinforandroiddev.domain.model.Forecast as ModelForecast
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList =
        ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = (Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())).toInt()
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
            forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    private fun convertDate(date: Int): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }
}