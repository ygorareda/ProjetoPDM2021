package com.mobile.pytournaments.repository
import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.mobile.pytournaments.R
import com.mobile.pytournaments.domain.LoginResult
import com.mobile.pytournaments.domain.UserModelo
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.http.GET
import retrofit2.http.Headers
import java.text.ParseException
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import com.mobile.pytournaments.repository.UserRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST


class LoginRepository @Inject constructor(
    private val auth: FirebaseAuth,
    @ApplicationContext val context: Context
){

    private fun parseResultError(isSuccessful: Boolean, e: Throwable?): LoginResult {
        return when (e) {
            is FirebaseAuthInvalidCredentialsException -> LoginResult(isSuccessful,
                context.getString(R.string.login_invalid_credentials), e)
            is FirebaseAuthInvalidUserException -> {
                val msg = when (e.errorCode) {
                    "ERROR_USER_NOT_FOUND" -> context.getString(R.string.login_user_not_found)
                    else -> context.getString(R.string.login_invalid_credentials)
                }
                LoginResult(isSuccessful ,msg, e)
            }
            else -> LoginResult(isSuccessful , context.getString(R.string.login_invalid_user), e)
        }
    }

    suspend fun sendLoginData(email: String?, password: String?): LoginResult = suspendCoroutine { nextStep ->
        val signIn = auth.signInWithEmailAndPassword(email!!, password!!)

        signIn.addOnCompleteListener{ signin ->
            val result = if(signin.isSuccessful){
                LoginResult(signin.isSuccessful,
                    context.getString(R.string.login_complete),
                    null)
            }
            else{
                parseResultError(signin.isSuccessful, signin.exception)
            }
            nextStep.resume(result)
        }
    }

    suspend fun sendSingUpData(email: String?, password: String?): LoginResult= suspendCoroutine { nextStep ->
        val singUp = auth.createUserWithEmailAndPassword(email!!, password!!)


        singUp.addOnCompleteListener{ signup ->
            val result = if(signup.isSuccessful){
                LoginResult(signup.isSuccessful,
                    context.getString(R.string.login_singup),
                    null)


            }
            else{
                parseResultError(signup.isSuccessful, signup.exception)
            }
            nextStep.resume(result)
        }

    }


    suspend fun sendForgotPasswordData(email: String?): LoginResult = suspendCoroutine { nextStep ->
        val forgot = auth.sendPasswordResetEmail(email!!)

        forgot.addOnCompleteListener{ email ->
            val result = if(email.isSuccessful){
                LoginResult(email.isSuccessful,
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



