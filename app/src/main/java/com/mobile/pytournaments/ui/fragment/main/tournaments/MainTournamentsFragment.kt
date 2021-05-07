package com.mobile.pytournaments.ui.fragment.main.tournaments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.pytournaments.R
import com.mobile.pytournaments.adapter.Horizontal_RecyclerView
import com.mobile.pytournaments.databinding.FragmentLoginBinding
import com.mobile.pytournaments.databinding.FragmentMainTournamentsBinding

class MainTournamentsFragment : Fragment() {

    private lateinit var biding: FragmentMainTournamentsBinding

    private  lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Horizontal_RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        biding = FragmentMainTournamentsBinding.inflate(inflater, container, false)


        recyclerView = biding.recyclerView
        adapter = Horizontal_RecyclerView()


        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = adapter



        return biding.root
    }


}