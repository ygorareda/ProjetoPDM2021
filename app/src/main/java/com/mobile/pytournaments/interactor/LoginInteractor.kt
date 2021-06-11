package com.mobile.pytournaments.interactor

import android.content.Context
import com.mobile.pytournaments.R
import com.mobile.pytournaments.domain.Result
import com.mobile.pytournaments.repository.LoginRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class LoginInteractor @Inject constructor(
    private val repository: LoginRepository,
    @ApplicationContext val context: Context
) {
    suspend fun login(email:String?, password:String?) : Result {
        val result = isValidCredentials(email, password)
        if (!result.success){
            return result
        }

        return repository.sendLoginData(email, password)
    }

    suspend fun signUp(email:String?, password:String?, passwordCheck:String?) : Result {
        val result = isValidCredentials(email, password)

        if (!result.success){
            return result
        }
        if(password != passwordCheck){
            return Result(
                false,
                context.getString(R.string.login_equal_passwords),
                null)
        }

        return repository.sendSingUpData(email, password)
    }

    suspend fun forgotPassword(email:String?) : Result {
        if (email.isNullOrBlank()){
            return Result(false ,context.getString(R.string.login_blank_email), null)
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return Result(false ,context.getString(R.string.login_invalid_email), null)
        }

        return repository.sendForgotPasswordData(email)
    }

    private fun isValidCredentials(email:String?, password:String?): Result {
        if (email.isNullOrBlank()){
            return Result(false ,context.getString(R.string.login_blank_email), null)
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return Result(false ,context.getString(R.string.login_invalid_email), null)
        }
        if (password.isNullOrBlank()){
            return Result(false ,context.getString(R.string.login_blank_password), null)
        }

        return Result(true, "", null)
    }





}