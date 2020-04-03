package com.example.kotlinforandroiddev.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [
    DatabaseCityForecast::class,
    DatabaseDayForecast::class], version = 1, exportSchema = false)
abstract class ForecastDatabases: RoomDatabase() {
    abstract val forecastDao: ForecastDao
}

private lateinit var INSTANCE: ForecastDatabases

fun getDatabase(context: Context): ForecastDatabases {
    synchronized(ForecastDatabases::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                ForecastDatabases::class.java,
                "forecast_databases")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
    return INSTANCE
}