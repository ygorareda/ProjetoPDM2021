package com.mobile.pytournaments.ui.fragment.main.tournaments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.pytournaments.MainActivity
import com.mobile.pytournaments.R
import com.mobile.pytournaments.adapter.Horizontal_RecyclerView
import com.mobile.pytournaments.databinding.FragmentLoginBinding
import com.mobile.pytournaments.databinding.FragmentMainTournamentsBinding

class MainTournamentsFragment : Fragment() {

    private lateinit var biding: FragmentMainTournamentsBinding

    //private  lateinit var recyclerView: RecyclerView
    private lateinit var rolagemHorizontalOnline : RecyclerView
    private lateinit var rolagemHorizontalPresencial : RecyclerView
    private lateinit var adapter: Horizontal_RecyclerView





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        biding = FragmentMainTournamentsBinding.inflate(inflater, container, false)



        rolagemHorizontalOnline = biding.rvListaHorizontalOnline
        rolagemHorizontalPresencial = biding.rvListaHorizontalPresencial
        adapter = Horizontal_RecyclerView()

        rolagemHorizontalPresencial.layoutManager =LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        rolagemHorizontalOnline.layoutManager =LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

        rolagemHorizontalOnline.adapter = adapter
        rolagemHorizontalPresencial.adapter = adapter



        return biding.root
    }






}