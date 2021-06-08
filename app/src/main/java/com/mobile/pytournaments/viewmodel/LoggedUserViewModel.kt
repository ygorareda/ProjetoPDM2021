package com.mobile.pytournaments.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mobile.pytournaments.domain.Tournament
import com.mobile.pytournaments.domain.User
import com.mobile.pytournaments.domain.UserModelo
import com.mobile.pytournaments.interactor.UserInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoggedUserViewModel @Inject constructor(
    app:Application,
    private val interactor: UserInteractor
) : AndroidViewModel(app){

    val loggedUser = MutableLiveData<User>()
    val tournamentHistory = MutableLiveData<List<Tournament>>()
    val loadusers = MutableLiveData<List<UserModelo>>()

    fun loadLoggedUserData(){
        val userInfo = interactor.searchForLoggedUserData()
        loggedUser.value = userInfo
        tournamentHistory.value = userInfo.tournamentsHistory
    }

    fun loadAllUsers(){
        viewModelScope.launch {
            loadusers.value = interactor.loadAllUsers()
            }

    }
}