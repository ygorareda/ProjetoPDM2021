package com.mobile.pytournaments.ui.fragment.main.tournaments.fragmentsTournament

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.mobile.pytournaments.R

class LocalizationTournamentsFragment : Fragment(),
    OnMapReadyCallback {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_localization_tournaments, container, false)
    }

    override fun onMapReady(p0: GoogleMap) {
        TODO("Not yet implemented")
    }


}