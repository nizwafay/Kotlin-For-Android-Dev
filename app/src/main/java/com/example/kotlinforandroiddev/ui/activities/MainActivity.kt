package com.example.kotlinforandroiddev.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinforandroiddev.R
import com.example.kotlinforandroiddev.data.WeatherApi
import com.example.kotlinforandroiddev.ui.adapters.ForecastListAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    private val items = listOf(
        "Mon 6/23 - Sunny - 31/17",
        "Tue 6/24 - Foggy - 21/8",
        "Wed 6/25 - Cloudy - 22/17",
        "Thurs 6/26 - Rainy - 18/11",
        "Fri 6/27 - Foggy - 21/10",
        "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
        "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        viewAdapter = ForecastListAdapter(items)

        recyclerView = findViewById<RecyclerView>(R.id.forecast_list).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        val url = "http://api.openweathermap.org/data/2.5/forecast/daily?" +
                "APPID=15646a06818f61f7b8d7823ca833e1ce&zip=94043&mode=json&units=metric&cnt=7"


        GlobalScope.launch(Dispatchers.Main) {
            val dailyWeather = getDailyWeather()
            Toast.makeText(this@MainActivity, dailyWeather, Toast.LENGTH_LONG).show()
        }
    }

    private suspend fun getDailyWeather(): String {
        return withContext(Dispatchers.IO) {
            WeatherApi.service.getDailyWeather()
        }
    }
}
