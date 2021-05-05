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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mobile.pytournaments.R
import com.mobile.pytournaments.databinding.FragmentForgotPasswordBinding
import com.mobile.pytournaments.databinding.FragmentLoginBinding
import com.mobile.pytournaments.databinding.FragmentLoginSignUpBinding
import javax.inject.Inject


class LoginSignUpFragment : Fragment() {

    lateinit var biding: FragmentLoginSignUpBinding
    @Inject
    lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        biding = FragmentLoginSignUpBinding.inflate(inflater, container, false)
        biding.lifecycleOwner = this

        auth = Firebase.auth
        biding.btSignUp.setOnClickListener {
            var email = biding.tvEmailSignUp.text.toString()
            var password = biding.tvPasswordSignUp.text.toString()
            var retype = biding.tvPasswordSignUpRetype.text.toString()

            if(password == retype){
                createAccount(email,password)
            }else{
                biding.tvPasswordSignUp.setText("")
                biding.tvPasswordSignUpRetype.setText("")
                Toast.makeText(this.context, "Senhas não conferem", Toast.LENGTH_SHORT).show()
            }
        }

        return biding.root


    }

    private fun createAccount(email: String, password: String) {
        Log.d(TAG, "createAccount:$email")

        if (TextUtils.isEmpty(email)) {
            biding.tvEmailSignUp.error = "Required"
            return
        }else{
            biding.tvEmailSignUp.error = null
        }
        if (TextUtils.isEmpty(password)) {
            biding.tvPasswordSignUp.error = "Required"
            return
        }else{
            biding.tvPasswordSignUp.error = null
        }

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        Toast.makeText(context, "Criado com sucesso", Toast.LENGTH_SHORT).show()

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(context, "Não foi criado",
                                Toast.LENGTH_SHORT).show()
                    }

                }
    }


}