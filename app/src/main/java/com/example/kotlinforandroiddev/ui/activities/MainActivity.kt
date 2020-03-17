package com.example.kotlinforandroiddev.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinforandroiddev.R
import com.example.kotlinforandroiddev.data.ForecastResult
import com.example.kotlinforandroiddev.data.WeatherApi
import com.example.kotlinforandroiddev.ui.adapters.ForecastListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        WeatherApi.retrofitService.getDailyWeather("94043").enqueue( object: Callback<ForecastResult> {
            override fun onFailure(call: Call<ForecastResult>, t: Throwable) {
                Log.d("MainActivity", "Failure: " + t.message)
            }

            override fun onResponse(call: Call<ForecastResult>, response: Response<ForecastResult>) {
                Log.d("MainActivity", "Success: " + response.body()?.city)
            }
        })
    }
}
