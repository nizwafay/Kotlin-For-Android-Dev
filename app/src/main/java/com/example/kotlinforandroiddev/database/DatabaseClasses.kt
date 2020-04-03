package com.example.kotlinforandroiddev.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DatabaseCityForecast(
    @PrimaryKey val id: Int,
    @ColumnInfo val city: String,
    @ColumnInfo val country: String
)

@Entity
data class DatabaseDayForecast(
    @PrimaryKey val id: Int,
    @ColumnInfo val date: String,
    @ColumnInfo val description: String,
    @ColumnInfo val high: Double,
    @ColumnInfo val low: Double,
    @ColumnInfo(name = "icon_url") val iconUrl: String,
    @ColumnInfo(name = "city_id") val cityId: Int
)