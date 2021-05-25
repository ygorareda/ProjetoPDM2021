package com.mobile.pytournaments.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.LinhaBinding
import com.mobile.pytournaments.domain.Tournament


class Horizontal_RecyclerView(
    private val tournamentList: List<Tournament>
): RecyclerView.Adapter<TournamentHorizontalViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentHorizontalViewHolder {
        val template = LayoutInflater.from(parent.context).inflate(R.layout.linha,
            parent, false)
        return TournamentHorizontalViewHolder(template)
    }

    override fun onBindViewHolder(holder: TournamentHorizontalViewHolder, position: Int) {
        holder.binding.tournamentLinha = tournamentList[position]
        holder.binding.executePendingBindings()
    }
    override fun getItemCount() = tournamentList.size

}

class TournamentHorizontalViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val binding = LinhaBinding.bind(v)
}