package com.mobile.pytournaments.ui.fragment.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentOnboardingTesteBinding
import com.mobile.pytournaments.ui.fragment.onboarding.screen.OnboardingFirstTesteFragment
import com.mobile.pytournaments.ui.fragment.onboarding.screen.OnboardingSecondTestFragment
import com.mobile.pytournaments.ui.fragment.screen.onboardingFragment


class OnboardingTesteFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingTesteBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentOnboardingTesteBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        val listafragmentos = listOf(OnboardingFirstTesteFragment(),OnboardingSecondTestFragment())

        val adaptador = AdaptadorOnboarding(listafragmentos, requireActivity().supportFragmentManager,lifecycle)

        binding.vpOnboarding.adapter = adaptador

        return binding.root
    }

    fun start(){

    }


}

class AdaptadorOnboarding(val listaFragmentos : List<Fragment>,fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int{
        return listaFragmentos.size
    }

    override fun createFragment(position: Int): Fragment {
        return listaFragmentos[position]
    }

}