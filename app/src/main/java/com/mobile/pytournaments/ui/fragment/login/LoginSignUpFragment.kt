package com.mobile.pytournaments.ui.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentLoginSignUpBinding
import com.mobile.pytournaments.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginSignUpFragment: Fragment() {

    lateinit var binding: FragmentLoginSignUpBinding
    val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginSignUpBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.signup = this
        binding.viewmodel = viewModel

        viewModel.loginResult.observe(viewLifecycleOwner) {
            if(it.success){
                Toast.makeText(context, "cadastrado", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_loginSignUpFragment_to_loginSignUpInfoFragment)
            }else{
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root

    }

    fun signUp(v:View){
         viewModel.signup()

    }
}