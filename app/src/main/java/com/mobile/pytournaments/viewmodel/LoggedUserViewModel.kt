package com.mobile.pytournaments.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mobile.pytournaments.domain.Tournament
import com.mobile.pytournaments.domain.User
import com.mobile.pytournaments.interactor.UserInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoggedUserViewModel @Inject constructor(
    app:Application,
    private val interactor: UserInteractor
) : AndroidViewModel(app){

    val loggedUser = MutableLiveData<User>()
    val tournamentHistory = MutableLiveData<List<Tournament>>()

    fun loadLoggedUserData(){
        val userInfo = interactor.searchForLoggedUserData()
        loggedUser.value = userInfo
        tournamentHistory.value = userInfo.tournamentsHistory
    }
}