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
import com.mobile.pytournaments.databinding.FragmentLoginBinding
import com.mobile.pytournaments.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ) : View{
        // Inflate the layout for this fragment

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.codigoDoFragmento = this
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        viewModel.loginResult.observe(viewLifecycleOwner) {
            if(it.success){
                requireActivity().finish()
                findNavController().navigate(R.id.action_loginFragment_to_homeActivity)
            }
            else{
                Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
            }
        }

        return binding.root

    }

    fun login(v: View){
        viewModel.login()
    }

    fun irEsqueciSenha(v: View) {
        findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)

    }

    fun irSignUp(v: View) {
        findNavController().navigate(R.id.action_loginFragment_to_loginSignUpFragment)
    }






}


