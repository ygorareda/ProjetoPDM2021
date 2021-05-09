package com.mobile.pytournaments.ui.fragment.main.tournaments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayoutMediator
import com.mobile.pytournaments.R
import com.mobile.pytournaments.adapter.Tournaments_Description_Adapter
import com.mobile.pytournaments.databinding.FragmentMainBinding
import com.mobile.pytournaments.databinding.FragmentTournamentsDescriptionBinding


class TournamentsDescriptionFragment : Fragment() {

    private lateinit var biding: FragmentTournamentsDescriptionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        biding = FragmentTournamentsDescriptionBinding.inflate(inflater, container, false)


        criaDeslizar()

        return biding.root
    }


    private fun criaDeslizar(){
        var tabLayout = biding.tlNavigation
        var viewPager = biding.vpNavigation
        var adapter = Tournaments_Description_Adapter(childFragmentManager,lifecycle)

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout,viewPager){tab,position ->
            when(position){
                0->{
                    tab.text= "Informações Gerais"
                }
                1->{
                    tab.text= "Lista de Participantes"
                }
                2->{
                    tab.text = "Localização"
                }
            }
        }.attach()



    }


}