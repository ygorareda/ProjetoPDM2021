package com.mobile.pytournaments.ui.fragment.login

import android.app.Activity
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentLoginBinding
import javax.inject.Inject


class LoginFragment : Fragment() {

    lateinit var biding: FragmentLoginBinding
    @Inject lateinit var auth: FirebaseAuth


    fun irEsqueciSenha(v: View){
        findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)

    }
    fun irSignUp(v: View){

        findNavController().navigate(R.id.action_loginFragment_to_loginSignUpFragment)
    }



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        biding = FragmentLoginBinding.inflate(inflater, container, false)
        biding.codigoDoFragmento = this
        biding.lifecycleOwner = this

        auth = Firebase.auth
        biding.btLoginLogon.setOnClickListener {


            val email = biding.tvEmailLogin.text.toString()
            val password = biding.tvPasswordLogin.text.toString()
            signIn(email, password)

            }



        return biding.root



    }

    private fun signIn(email: String, password: String) {
        Log.d(TAG, "signIn:$email")

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        Toast.makeText(context,"deu bom mano",Toast.LENGTH_SHORT).show()

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(context, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                    }


                }
    }


}