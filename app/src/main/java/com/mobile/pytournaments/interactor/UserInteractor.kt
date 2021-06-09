package com.mobile.pytournaments.interactor

import android.util.Log
import com.mobile.pytournaments.domain.UserCadastraApi
import com.mobile.pytournaments.domain.UserModelo
import com.mobile.pytournaments.repository.UserRepository
import retrofit2.Call
import javax.inject.Inject

class UserInteractor @Inject constructor(
    private val repository: UserRepository
) {

    suspend fun loadAllUsers(): List<UserModelo> {
        return repository.loadAllUsers()

    }

    suspend fun signUpUsersBd(name: String, username: String): Call<String> {
        return repository.signUpUsersBd(name,username)
    }


}