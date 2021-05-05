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
import javax.inject.Inject

class ForgotPasswordFragment : Fragment() {

    lateinit var biding: FragmentForgotPasswordBinding
    @Inject
    lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        biding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        biding.lifecycleOwner = this

        auth = Firebase.auth
        biding.btForgotPassword.setOnClickListener {
            var email = biding.tvEmailForgot.text.toString()
            sendEmailReset(email)
        }

        return biding.root
    }


    private fun sendEmailReset(email: String) {
        if (TextUtils.isEmpty(email)) {
            biding.tvEmailForgot.error = "Required"
            return
        }else{
            biding.tvEmailForgot.error = null
        }

        Firebase.auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(context, "Email to reset passoword has sent",
                                Toast.LENGTH_SHORT).show()
                    }
                }
    }





}