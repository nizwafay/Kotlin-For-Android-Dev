package com.example.kotlinforandroiddev.ui.adapters

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinforandroiddev.domain.model.ForecastList

class ForecastListAdapter(private val items: ForecastList):
        RecyclerView.Adapter<ForecastListAdapter.ForecastViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(
            TextView(parent.context)
        )
    }

    override fun getItemCount(): Int = items.dailyForecast.size

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        with(items.dailyForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }

    }

    class ForecastViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)
}