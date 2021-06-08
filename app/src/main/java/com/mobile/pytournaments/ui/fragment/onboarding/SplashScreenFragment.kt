package com.mobile.pytournaments.ui.fragment.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentSplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SplashScreenFragment : Fragment() {

    private lateinit var binding:FragmentSplashScreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        GlobalScope.
        launch(context = Dispatchers.Main) {
            delay(4000)
            findNavController().navigate(R.id.action_splashScreenFragment_to_onboardingFragment)
        }

        return binding.root

    }

}