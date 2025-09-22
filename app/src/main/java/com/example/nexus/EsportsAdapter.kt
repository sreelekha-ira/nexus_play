package com.example.nexus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EsportsAdapter(private val esportsList: List<EsportItem>) :
    RecyclerView.Adapter<EsportsAdapter.EsportsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EsportsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_esport, parent, false)
        return EsportsViewHolder(view)
    }

    override fun onBindViewHolder(holder: EsportsViewHolder, position: Int) {
        val item = esportsList[position]
        holder.title.text = item.title
        holder.image.setImageResource(item.imageRes)
    }

    override fun getItemCount(): Int = esportsList.size

    class EsportsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.esportTitle)
        val image: ImageView = itemView.findViewById(R.id.esportImage)
    }
}
