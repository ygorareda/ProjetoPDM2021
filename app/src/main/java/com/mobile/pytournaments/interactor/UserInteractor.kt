package com.mobile.pytournaments.interactor

import com.mobile.pytournaments.repository.UserRepository
import javax.inject.Inject

class UserInteractor @Inject constructor(
    private val repository: UserRepository
) {

    fun searchForLoggedUserData() = repository.searchForLoggedUserData()
}