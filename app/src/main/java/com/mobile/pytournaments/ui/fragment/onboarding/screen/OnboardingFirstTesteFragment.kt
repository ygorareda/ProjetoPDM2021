package com.mobile.pytournaments.ui.fragment.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentOnboardingFirstTesteBinding


class OnboardingFirstTesteFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingFirstTesteBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingFirstTesteBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this



        // Inflate the layout for this fragment
        return binding.root
    }


}