package com.mobile.pytournaments.ui.fragment.main.tournaments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.mobile.pytournaments.databinding.FragmentTournamentsDescriptionBinding
import com.mobile.pytournaments.domain.Tournament
import com.mobile.pytournaments.ui.adapter.TournamentDescriptionAdapter
import com.mobile.pytournaments.ui.fragment.main.tournaments.fragmentsTournament.GeneralInformationFragment
import com.mobile.pytournaments.ui.fragment.main.tournaments.fragmentsTournament.LocalizationTournamentsFragment
import com.mobile.pytournaments.ui.fragment.main.tournaments.fragmentsTournament.ParticipantsTournamentFragment
import com.mobile.pytournaments.viewmodel.SharedViewModel


class TournamentsDescriptionFragment : Fragment() {

    private lateinit var binding: FragmentTournamentsDescriptionBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val selectedTournament = (sharedViewModel.getSelectedItem() as Tournament)

        binding = FragmentTournamentsDescriptionBinding.inflate(inflater, container, false)
        binding.tournament = selectedTournament
        binding.tournamentDescription = this
        binding.lifecycleOwner = this


        val pages = arrayListOf(
            GeneralInformationFragment(selectedTournament),
            ParticipantsTournamentFragment(),
            LocalizationTournamentsFragment(selectedTournament)
        )

        binding.tournamentName.text = selectedTournament.name
        binding.tournamentName.text = selectedTournament.getStringDate()

        binding.vpTournamentInfo.adapter =
            TournamentDescriptionAdapter(pages, requireActivity().supportFragmentManager, lifecycle)

        binding.wormDotsIndicator.setViewPager2(binding.vpTournamentInfo)

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