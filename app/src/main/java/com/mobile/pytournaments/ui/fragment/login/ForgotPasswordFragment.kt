package com.mobile.pytournaments.ui.fragment.login

import android.content.ContentValues.TAG
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentForgotPasswordBinding
import com.mobile.pytournaments.databinding.FragmentLoginBinding
import com.mobile.pytournaments.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception
import javax.inject.Inject

@AndroidEntryPoint
class ForgotPasswordFragment : Fragment() {

    lateinit var binding: FragmentForgotPasswordBinding
    val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.forgot = this
        binding.viewmodel = viewModel

        viewModel.loginResult.observe(viewLifecycleOwner) {
            Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
        }

        return binding.root
    }
    
    fun forgotPassword(v:View){
        viewModel.forgot()
    }

}