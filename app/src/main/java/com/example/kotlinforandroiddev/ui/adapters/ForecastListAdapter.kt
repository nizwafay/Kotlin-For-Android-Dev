package com.example.kotlinforandroiddev.ui.adapters

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ForecastListAdapter(private val items: List<String>):
        RecyclerView.Adapter<ForecastListAdapter.ForecastViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(
            TextView(parent.context)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    class ForecastViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)
}