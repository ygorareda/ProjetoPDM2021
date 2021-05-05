package com.mobile.pytournaments.ui.fragment.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentOnboardingSecondTestBinding


class OnboardingSecondTestFragment : Fragment() {

    private lateinit var binding : FragmentOnboardingSecondTestBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingSecondTestBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        // Inflate the layout for this fragment
        return binding.root
    }

}