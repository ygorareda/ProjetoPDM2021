package com.mobile.pytournaments.ui.fragment.main.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.pytournaments.R
import com.mobile.pytournaments.adapter.Grid_RecyclerView
import com.mobile.pytournaments.adapter.Horizontal_RecyclerView
import com.mobile.pytournaments.databinding.FragmentMainBinding
import com.mobile.pytournaments.databinding.FragmentProfileMainUserBinding
import com.mobile.pytournaments.ui.fragment.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileMainUserFragment : Fragment() {

    private lateinit var rolagemHorizontalParticipados: RecyclerView
    private lateinit var adapter: Horizontal_RecyclerView
    private lateinit var biding: FragmentProfileMainUserBinding


    fun redirecionarAmigos(v: View){
        findNavController().navigate(R.id.action_profileMainUserFragment_to_profileFriendUserFragment)
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        biding = FragmentProfileMainUserBinding.inflate(inflater, container, false)
//        biding.redirecionar = this
//
//        rolagemHorizontalParticipados = biding.rvTorneiosParticipadosProfile
//        adapter = Horizontal_RecyclerView(listOf())
//
//        rolagemHorizontalParticipados.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
//        rolagemHorizontalParticipados.adapter = adapter


        return biding.root
    }




}