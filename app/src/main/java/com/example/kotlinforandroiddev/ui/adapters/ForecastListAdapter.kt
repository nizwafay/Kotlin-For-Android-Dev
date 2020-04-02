package com.example.kotlinforandroiddev.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinforandroiddev.R
import com.example.kotlinforandroiddev.domain.model.Forecast
import com.example.kotlinforandroiddev.domain.model.ForecastList
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastListAdapter(
    private val items: ForecastList,
    private val onClick: (Forecast) -> Unit
): RecyclerView.Adapter<ForecastListAdapter.ForecastViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_forecast, parent, false)

        return ForecastViewHolder(view, onClick)
    }

    override fun getItemCount() = items.size()

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ForecastViewHolder(
        private val view: View,
        private val itemClick: (Forecast) -> Unit
    ): RecyclerView.ViewHolder(view) {

        fun bind(forecast: Forecast) {
            with(forecast) {
                Glide.with(view).load(iconUrl).into(itemView.icon)
                itemView.dateText.text = date
                itemView.descriptionText.text = description
                itemView.maxTemperature.text = high.toString()
                itemView.minTemperature.text = low.toString()
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}