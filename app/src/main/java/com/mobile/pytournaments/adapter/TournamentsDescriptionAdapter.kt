package com.mobile.pytournaments.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mobile.pytournaments.ui.fragment.main.tournaments.fragmentsTournament.GeneralInformationFragment
import com.mobile.pytournaments.ui.fragment.main.tournaments.fragmentsTournament.LocalizationTournamentsFragment
import com.mobile.pytournaments.ui.fragment.main.tournaments.fragmentsTournament.ParticipantsTournamentFragment

class TournamentsDescriptionAdapter(fragmentManager : FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                GeneralInformationFragment()
            }
            1->{
                ParticipantsTournamentFragment()
            }
            2->{
                LocalizationTournamentsFragment()
            }
            else->{
                Fragment()
            }
        }
    }


}