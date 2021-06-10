package com.mobile.pytournaments.ui.fragment.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentLoginSignUpBinding
import com.mobile.pytournaments.databinding.FragmentLoginSignUpInfoBinding
import com.mobile.pytournaments.databinding.FragmentProfileMainUserBinding
import com.mobile.pytournaments.ui.fragment.main.profile.ProfileMainUserFragment
import com.mobile.pytournaments.viewmodel.LoggedUserViewModel
import com.mobile.pytournaments.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginSignUpInfoFragment : Fragment() {

    lateinit var binding: FragmentLoginSignUpInfoBinding
    val viewModel: LoggedUserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginSignUpInfoBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.fragment = this
        binding.viewmodel = viewModel


        viewModel.usertoken.observe(viewLifecycleOwner) {
            requireActivity().finish()
            findNavController().navigate(R.id.action_loginSignUpInfoFragment_to_homeActivity)
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }



        return binding.root
    }

    fun signUpUsersBd(v: View){
        viewModel.signUpUsersBd()
    }
}