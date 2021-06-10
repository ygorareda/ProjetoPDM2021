package com.mobile.pytournaments.interactor

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mobile.pytournaments.domain.UserCadastraApi
import com.mobile.pytournaments.domain.UserModelo
import com.mobile.pytournaments.repository.UserRepository
import retrofit2.Call
import javax.inject.Inject

class UserInteractor @Inject constructor(
    private val repository: UserRepository

) {

    suspend fun loadAllFriends(): List<UserCadastraApi> {
        return repository.loadAllFriends()

    }

    suspend fun signUpUsersBd(name : String, username : String): String {
        return repository.signUpUsersBd(name, username)
    }

    suspend fun loadUniqueUser(): UserCadastraApi {
        return repository.loadUniqueUser()
    }


}