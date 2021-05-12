package com.mobile.pytournaments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.ColunaBinding
import com.mobile.pytournaments.databinding.LinhaBinding
import com.mobile.pytournaments.domain.Tournament

class Grid_RecyclerView(
    private val tournamentList: List<Tournament>
): RecyclerView.Adapter<TournamentGridViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentGridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coluna,
            parent, false)
        return TournamentGridViewHolder(view)
    }

    override fun onBindViewHolder(holder: TournamentGridViewHolder, position: Int) {
        holder.binding.tournamentColuna = tournamentList[position+1]
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = tournamentList.size

}


class TournamentGridViewHolder(v: View): RecyclerView.ViewHolder(v) {
    val binding = ColunaBinding.bind(v)
}