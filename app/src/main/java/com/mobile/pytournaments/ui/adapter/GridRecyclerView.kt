package com.mobile.pytournaments.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.ColunaBinding
import com.mobile.pytournaments.domain.Tournament

class Grid_RecyclerView(
    private val tournamentList: List<Tournament>,
    private val onItemListener: OnClickListener
): RecyclerView.Adapter<Grid_RecyclerView.TournamentGridViewHolder>() {

    inner class TournamentGridViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val binding = ColunaBinding.bind(v)

        init{
            itemView.setOnClickListener{
                onItemListener.onRecycleViewClick(bindingAdapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentGridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coluna,
            parent, false)
        return TournamentGridViewHolder(view)
    }

    override fun onBindViewHolder(holder: TournamentGridViewHolder, position: Int) {
        holder.binding.tournamentColuna = tournamentList[position]
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = tournamentList.size

    interface OnClickListener{
        fun onRecycleViewClick(position: Int)
    }

}


