package com.mobile.pytournaments.ui.fragment.main.tournaments.fragmentsTournament

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentGeneralInformationBinding
import com.mobile.pytournaments.databinding.FragmentTournamentsDescriptionBinding
import com.mobile.pytournaments.domain.Tournament
import com.mobile.pytournaments.viewmodel.SharedViewModel

class GeneralInformationFragment(private val tournament: Tournament) : Fragment() {

    lateinit var binding: FragmentGeneralInformationBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val selectedTournament = (sharedViewModel.getSelectedItem() as Tournament)

        binding = FragmentGeneralInformationBinding.inflate(inflater, container, false)
        binding.tournament = selectedTournament
        binding.generalInformation = this
        binding.lifecycleOwner = this

        binding.tvTournamentDescription.text = selectedTournament.description

        return binding.root
    }


}