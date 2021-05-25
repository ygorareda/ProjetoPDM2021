package com.mobile.pytournaments.ui.fragment.main.tournaments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.mobile.pytournaments.R
import com.mobile.pytournaments.adapter.TournamentsDescriptionAdapter
import com.mobile.pytournaments.databinding.FragmentTournamentsDescriptionBinding
import com.mobile.pytournaments.ui.adapter.TournamentDescriptionAdapter
import com.mobile.pytournaments.ui.fragment.main.tournaments.fragmentsTournament.GeneralInformationFragment
import com.mobile.pytournaments.ui.fragment.main.tournaments.fragmentsTournament.LocalizationTournamentsFragment
import com.mobile.pytournaments.ui.fragment.main.tournaments.fragmentsTournament.ParticipantsTournamentFragment


class TournamentsDescriptionFragment : Fragment() {

    private lateinit var binding: FragmentTournamentsDescriptionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentTournamentsDescriptionBinding.inflate(inflater, container, false)
        binding.tournamentDescription = this
        binding.lifecycleOwner = this

        val pages = arrayListOf(
            GeneralInformationFragment(),
            ParticipantsTournamentFragment(),
            LocalizationTournamentsFragment()
        )

        binding.vpTournamentInfo.adapter =
            TournamentDescriptionAdapter(pages, requireActivity().supportFragmentManager, lifecycle)

        return binding.root
    }



//    private fun criaDeslizar(){
//        var tabLayout = biding.tlNavigation
//        var viewPager = biding.vpNavigation
//        var adapter = TournamentsDescriptionAdapter(childFragmentManager,lifecycle)
//
//        viewPager.adapter = adapter
//
//        TabLayoutMediator(tabLayout,viewPager){tab,position ->
//            when(position){
//                0->{
//                    tab.text= "Informações Gerais"
//                }
//                1->{
//                    tab.text= "Lista de Participantes"
//                }
//                2->{
//                    tab.text = "Localização"
//                }
//            }
//        }.attach()
//
//
//
//    }


}