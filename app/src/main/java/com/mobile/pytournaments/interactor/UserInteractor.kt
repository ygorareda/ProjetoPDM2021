package com.mobile.pytournaments.interactor

import com.mobile.pytournaments.domain.UserApiRetorno
import com.mobile.pytournaments.domain.UserModelo
import com.mobile.pytournaments.repository.UserRepository
import javax.inject.Inject

class UserInteractor @Inject constructor(
    private val repository: UserRepository
) {

    suspend fun loadAllUsers(): List<UserModelo> {
        return repository.loadAllUsers()

    }


}