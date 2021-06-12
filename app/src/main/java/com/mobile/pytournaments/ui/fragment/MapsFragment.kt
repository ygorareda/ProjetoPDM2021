package com.mobile.pytournaments.ui.fragment

import android.content.pm.PackageManager
import android.location.LocationListener
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.snackbar.Snackbar
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentMapsBinding
import com.mobile.pytournaments.viewmodel.CreateTournamentViewModel


class MapsFragment : Fragment(), OnMapReadyCallback {
    private val MAP_REQUEST_TICKET = 9999

    private lateinit var binding: FragmentMapsBinding
    private val viewModel: CreateTournamentViewModel by activityViewModels()
    private lateinit var ponto: MarkerOptions
    private lateinit var map: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapsBinding.inflate(inflater, container, false)
        binding.mapsFragment = this
        binding.lifecycleOwner = this
        // Recupera a instância do mapa configurado na atividade
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        // Solicita a apresentação do mapa em background
        mapFragment.getMapAsync(this)

        return binding.root
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        configMap()

        val posicaoIESB = LatLng(-15.834963163926998, -47.91285006006427)
//        val pinoIESB = MarkerOptions().position(posicaoIESB).title("IESB Campus Sul")
//        map.addMarker(pinoIESB)

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(posicaoIESB, 13f))

        map.setOnMapLongClickListener { ponto -> adicionarPino(ponto) }

    }

    private fun adicionarPino(ponto: LatLng) {
        val novoPino = MarkerOptions().position(ponto).title(viewModel.name.value)
        map.clear()
        this.ponto = novoPino
        viewModel.lat.value = ponto.latitude
        viewModel.lng.value = ponto.longitude

        map.addMarker(novoPino)
    }

    private fun configMap(){
        map.uiSettings.isMyLocationButtonEnabled = true
        map.uiSettings.isTiltGesturesEnabled = false
    }

    fun confirmLocation(v : View){
        findNavController().navigate(R.id.action_mapsFragment_to_createTournamentFragment)
    }
    // Verifica se o usuário concedeu a permissão para acesso à localização
//    private fun checkPermission() {
//        if (ActivityCompat.checkSelfPermission(
//                requireContext(),
//                android.Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            ActivityCompat.requestPermissions(
//                requireActivity(),
//                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
//                MAP_REQUEST_TICKET
//            )
//        } else {
//            setupLocation()
//        }
//    }

    // Esse método é executado quando o usuário responde à solicitação de alguma
    // permissão do aplicativo. Neste caso estamos solicitando a permissão para
    // acesso à localização do dispositivo.
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//
//        if (requestCode == MAP_REQUEST_TICKET) { // VERIFICA SE A RESPOSTA É PARA A SOLICITAÇÃO DO MAPA
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                setupLocation()
//            } else {
//                showSnackbar("A permissão de localização é obrigatória!") {
//                    checkPermission()
//                }
//            }
//        }
//    }
//
//    private fun showSnackbar(msg: String, callback: () -> Unit) {
//        val rootView = requireView().findViewById<View>(android.R.id.content).rootView
//        Snackbar
//            .make(rootView, msg, Snackbar.LENGTH_LONG)
//            .setAction("Aceito") {
//                callback()
//            }
//            .show()
//    }




}