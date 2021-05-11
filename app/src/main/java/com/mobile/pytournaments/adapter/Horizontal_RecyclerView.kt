package com.mobile.pytournaments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mobile.pytournaments.R
import com.mobile.pytournaments.ui.fragment.main.tournaments.MainTournamentsFragment


class Horizontal_RecyclerView: RecyclerView.Adapter<Horizontal_RecyclerView.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.linha, parent, false)
        var teste = LayoutInflater.from(parent.context).inflate(R.layout.fragment_tournaments_description,parent,false)

        return MyViewHolder(view, parent,teste)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {



    }
    override fun getItemCount(): Int {
        return 25
    }

    class MyViewHolder(itemView: View, parent: ViewGroup, teste : View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                Toast.makeText(itemView.context,"teste",Toast.LENGTH_LONG).show()
                //var teste = LayoutInflater.from(itemView.context).inflate(R.layout.fragment_tournaments_description,parent,false)

                 itemView.findNavController().navigate(R.id.action_mainTournamentsFragment_to_tournamentsDescriptionFragment)




            }



            }
        }



}
