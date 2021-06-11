package com.mobile.pytournaments.ui.fragment.main.tournaments.fragmentsTournament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentLocalizationTournamentsBinding
import com.mobile.pytournaments.domain.Tournament

class LocalizationTournamentsFragment(private val tournament: Tournament) : Fragment(),
    OnMapReadyCallback {

    private lateinit var binding: FragmentLocalizationTournamentsBinding
    private lateinit var pointOnMap: MarkerOptions
    private lateinit var map: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocalizationTournamentsBinding.inflate(inflater, container, false)
        binding.tournament = tournament
        binding.localizationFragment = this
        binding.lifecycleOwner = this


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recupera a instância do mapa configurado na atividade
        val mapFragment = (childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment)

        // Solicita a apresentação do mapa em background
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        setupMap()

        val posicao= LatLng(tournament.location.lat, tournament.location.lng)
        val pino = MarkerOptions().position(posicao).title(tournament.name)
        pointOnMap = pino
        map.addMarker(pino)

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(posicao, 14f))

    }

    private fun setupMap(){
        map.uiSettings.isTiltGesturesEnabled = false
        map.uiSettings.isZoomGesturesEnabled = false
        map.uiSettings.isScrollGesturesEnabled = false
        map.uiSettings.isScrollGesturesEnabledDuringRotateOrZoom = false
        map.uiSettings.isRotateGesturesEnabled = false
        map.uiSettings.isZoomControlsEnabled = true
        map.uiSettings.isMapToolbarEnabled = true
    }


}