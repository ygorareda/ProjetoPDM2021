package com.mobile.pytournaments.ui.fragment.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentOnboardingBinding
import com.mobile.pytournaments.ui.adapter.OnboardingAdapter
import com.mobile.pytournaments.ui.fragment.onboarding.screen.OnboardingFirstScreenFragment
import com.mobile.pytournaments.ui.fragment.onboarding.screen.OnboardingSecondScreenFragment
import com.mobile.pytournaments.ui.fragment.onboarding.screen.OnboardingThirdScreenFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingFragment : Fragment() {

    private lateinit var binding:FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.onboarding = this

        val pages = arrayListOf(OnboardingFirstScreenFragment(),
                OnboardingSecondScreenFragment(),
                OnboardingThirdScreenFragment())

        binding.onboardingviewPager.adapter = OnboardingAdapter(
            pages, requireActivity().supportFragmentManager,lifecycle
        )

        // Inflate the layout for this fragment
        return binding.root
    }

    fun goToLoginFragment(v:View){
        findNavController().navigate(R.id.action_onboardingFragment_to_loginFragment)
    }
}