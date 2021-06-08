package com.mobile.pytournaments.interactor

import android.content.Context
import com.mobile.pytournaments.R
import com.mobile.pytournaments.domain.LoginResult
import com.mobile.pytournaments.repository.LoginRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class LoginInteractor @Inject constructor(
    private val repository: LoginRepository,
    @ApplicationContext val context: Context
) {
    suspend fun login(email:String?, password:String?) : LoginResult{
        val result = isValidCredentials(email, password)
        if (!result.success){
            return result
        }

        return repository.sendLoginData(email, password)
    }

    suspend fun signUp(email:String?, password:String?, passwordCheck:String?) : LoginResult{
        val result = isValidCredentials(email, password)

        if (!result.success){
            return result
        }
        if(password != passwordCheck){
            return LoginResult(
                false,
                context.getString(R.string.login_equal_passwords),
                null)
        }

        return repository.sendSingUpData(email, password)
    }

    suspend fun forgotPassword(email:String?) : LoginResult{
        if (email.isNullOrBlank()){
            return LoginResult(false ,context.getString(R.string.login_blank_email), null)
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return LoginResult(false ,context.getString(R.string.login_invalid_email), null)
        }

        return repository.sendForgotPasswordData(email)
    }

    private fun isValidCredentials(email:String?, password:String?): LoginResult {
        if (email.isNullOrBlank()){
            return LoginResult(false ,context.getString(R.string.login_blank_email), null)
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return LoginResult(false ,context.getString(R.string.login_invalid_email), null)
        }
        if (password.isNullOrBlank()){
            return LoginResult(false ,context.getString(R.string.login_blank_password), null)
        }

        return LoginResult(true, "", null)
    }
    




}