package com.mobile.pytournaments.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentForgotPasswordBinding
import com.mobile.pytournaments.databinding.FragmentLoginBinding
import com.mobile.pytournaments.ui.activity.LoginActivity
import javax.inject.Inject


class LoginFragment : Fragment() {

    lateinit var biding: FragmentLoginBinding
    @Inject lateinit var auth: FirebaseAuth


    fun irEsqueciSenha(v:View){
        findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)

    }
    fun irSignUp(v:View){



        findNavController().navigate(R.id.action_loginFragment_to_loginSignUpFragment)
    }
    /*
    fun logar(){
        var email = R.id.tvEmailLogin
        var password = R.id.tvPasswordLogin


        this.activity?.let {
            auth.createUserWithEmailAndPassword(email.toString(), password.toString())
                .addOnCompleteListener(it) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(this.activity,"Deu certo", Toast.LENGTH_SHORT).show()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this.activity, "Deu Ruim",
                                Toast.LENGTH_SHORT).show()
                    }
                }
        }



    }

    */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        biding = FragmentLoginBinding.inflate(inflater,container, false)
        biding.codigoDoFragmento = this
        biding.lifecycleOwner = this

        return biding.root



    }






}