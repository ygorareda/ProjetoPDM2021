package com.mobile.pytournaments.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentLoginSignUpBinding
import com.mobile.pytournaments.databinding.FragmentLoginSignUpInfoBinding
import com.mobile.pytournaments.viewmodel.LoginViewModel

class LoginSignUpInfoFragment : Fragment() {

    lateinit var binding: FragmentLoginSignUpInfoBinding
    val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginSignUpInfoBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.fragment = this
        binding.viewmodel = viewModel

        return binding.root
    }
}