package com.example.nexus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TournamentAdapter(private val tournamentList: List<TournamentItem>) :
    RecyclerView.Adapter<TournamentAdapter.TournamentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tournament, parent, false)
        return TournamentViewHolder(view)
    }

    override fun onBindViewHolder(holder: TournamentViewHolder, position: Int) {
        val item = tournamentList[position]
        holder.title.text = item.title
        holder.image.setImageResource(item.imageRes)
    }

    override fun getItemCount(): Int = tournamentList.size

    class TournamentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tournamentTitle)
        val image: ImageView = itemView.findViewById(R.id.tournamentImage)
    }
}
