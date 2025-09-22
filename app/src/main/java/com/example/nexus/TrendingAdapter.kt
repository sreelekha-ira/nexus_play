package com.example.nexus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TrendingAdapter(private val trendingList: List<TrendingItem>) :
    RecyclerView.Adapter<TrendingAdapter.TrendingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_trending, parent, false)
        return TrendingViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        val item = trendingList[position]
        holder.title.text = item.title
        holder.image.setImageResource(item.imageRes)
    }

    override fun getItemCount(): Int = trendingList.size

    class TrendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.trendingTitle)
        val image: ImageView = itemView.findViewById(R.id.trendingImage)
    }
}
