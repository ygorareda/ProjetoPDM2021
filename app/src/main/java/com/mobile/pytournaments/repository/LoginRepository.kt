package com.mobile.pytournaments.repository
import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.mobile.pytournaments.R
import com.mobile.pytournaments.domain.Result
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class LoginRepository @Inject constructor(
    private val auth: FirebaseAuth,
    @ApplicationContext val context: Context
){

    private fun parseResultError(isSuccessful: Boolean, e: Throwable?): Result {
        return when (e) {
            is FirebaseAuthInvalidCredentialsException -> Result(isSuccessful,
                context.getString(R.string.login_invalid_credentials), e)
            is FirebaseAuthInvalidUserException -> {
                val msg = when (e.errorCode) {
                    "ERROR_USER_NOT_FOUND" -> context.getString(R.string.login_user_not_found)
                    else -> context.getString(R.string.login_invalid_credentials)
                }
                Result(isSuccessful ,msg, e)
            }
            else -> Result(isSuccessful , context.getString(R.string.login_invalid_user), e)
        }
    }

    suspend fun sendLoginData(email: String?, password: String?): Result = suspendCoroutine { nextStep ->
        val signIn = auth.signInWithEmailAndPassword(email!!, password!!)

        signIn.addOnCompleteListener{ signin ->
            val result = if(signin.isSuccessful){
                Result(signin.isSuccessful,
                    context.getString(R.string.login_complete),
                    null)
            }
            else{
                parseResultError(signin.isSuccessful, signin.exception)
            }
            nextStep.resume(result)
        }
    }

    suspend fun sendSingUpData(email: String?, password: String?): Result = suspendCoroutine { nextStep ->
        val singUp = auth.createUserWithEmailAndPassword(email!!, password!!)


        singUp.addOnCompleteListener{ signup ->
            val result = if(signup.isSuccessful){
                Result(signup.isSuccessful,
                    context.getString(R.string.login_singup),
                    null)


            }
            else{
                parseResultError(signup.isSuccessful, signup.exception)
            }
            nextStep.resume(result)
        }

    }


    suspend fun sendForgotPasswordData(email: String?): Result = suspendCoroutine { nextStep ->
        val forgot = auth.sendPasswordResetEmail(email!!)

        forgot.addOnCompleteListener{ email ->
            val result = if(email.isSuccessful){
                Result(email.isSuccessful,
                    context.getString(R.string.login_forgot),
                    null)
                    }
                    else{
                        parseResultError(email.isSuccessful, email.exception)
                    }
            nextStep.resume(result)
        }
    }

}



