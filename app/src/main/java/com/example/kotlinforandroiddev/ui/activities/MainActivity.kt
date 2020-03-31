package com.example.kotlinforandroiddev.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinforandroiddev.R
import com.example.kotlinforandroiddev.data.WeatherApi
import com.example.kotlinforandroiddev.domain.commands.RequestForecastCommand
import com.example.kotlinforandroiddev.ui.adapters.ForecastListAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)

        val forecastList = findViewById<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = viewManager

        GlobalScope.launch(Dispatchers.Main) {
            val dailyWeather = RequestForecastCommand("94043").execute()
            forecastList.adapter = ForecastListAdapter(dailyWeather)
        }
    }
}
