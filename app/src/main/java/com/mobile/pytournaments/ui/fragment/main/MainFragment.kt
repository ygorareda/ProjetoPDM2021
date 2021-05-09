package com.mobile.pytournaments.ui.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.GridLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mobile.pytournaments.R
import com.mobile.pytournaments.adapter.Grid_RecyclerView
import com.mobile.pytournaments.databinding.FragmentMainBinding
import com.mobile.pytournaments.databinding.FragmentMainTournamentsBinding


class MainFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Grid_RecyclerView
    private lateinit var biding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        biding = FragmentMainBinding.inflate(inflater, container, false)

        recyclerView = biding.rvRoalegmTorneiosParticipados
        adapter = Grid_RecyclerView()

        recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.adapter = adapter


        return biding.root
    }


}