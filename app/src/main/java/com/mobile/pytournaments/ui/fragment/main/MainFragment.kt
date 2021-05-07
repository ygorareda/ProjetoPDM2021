package com.mobile.pytournaments.ui.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var biding: FragmentMainBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        biding = FragmentMainBinding.inflate(inflater, container, false)
        biding.mainFragment = this
        biding.lifecycleOwner = this

        return biding.root

    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }

}