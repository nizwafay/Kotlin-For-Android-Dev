package com.example.kotlinforandroiddev.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinforandroiddev.R
import com.example.kotlinforandroiddev.domain.model.Forecast
import com.example.kotlinforandroiddev.domain.model.ForecastList

class ForecastListAdapter(
    private val items: ForecastList,
    private val onClick: (Forecast) -> Unit
): RecyclerView.Adapter<ForecastListAdapter.ForecastViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_forecast, parent, false)

        return ForecastViewHolder(view, onClick)
    }

    override fun getItemCount(): Int = items.size()

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ForecastViewHolder(
        private val view: View,
        private val itemClick: (Forecast) -> Unit
    ): RecyclerView.ViewHolder(view) {

        private val iconView: ImageView = view.findViewById(R.id.icon)
        private val dateView: TextView = view.findViewById(R.id.date)
        private val descriptionView: TextView = view.findViewById(R.id.description)
        private val maxTemperatureView: TextView = view.findViewById(R.id.maxTemperature)
        private val minTemperatureView: TextView = view.findViewById(R.id.minTemperature)

        fun bind(forecast: Forecast) {
            with(forecast) {
                Glide.with(view).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = high.toString()
                minTemperatureView.text = low.toString()
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}