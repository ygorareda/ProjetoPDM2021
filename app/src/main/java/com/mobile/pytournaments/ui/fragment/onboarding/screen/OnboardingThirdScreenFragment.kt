package com.mobile.pytournaments.ui.fragment.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentOnboardingFirstScreenBinding
import com.mobile.pytournaments.databinding.FragmentOnboardingThirdScreenBinding

class OnboardingThirdScreenFragment : Fragment() {
    lateinit var binding: FragmentOnboardingThirdScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingThirdScreenBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

}