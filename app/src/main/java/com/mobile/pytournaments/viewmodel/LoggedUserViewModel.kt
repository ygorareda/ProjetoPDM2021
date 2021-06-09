package com.mobile.pytournaments.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mobile.pytournaments.domain.Game
import com.mobile.pytournaments.domain.UserCadastraApi
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

    val loadusers = MutableLiveData<List<UserModelo>>()
    val usertoken = MutableLiveData<String>()

    val name = MutableLiveData<String>()
    val username = MutableLiveData<String>()
    //var user = MutableLiveData<UserCadastraApi>()
    val signUpInfoPreferences = MutableLiveData<List<Game>>()

    fun loadAllUsers(){
        viewModelScope.launch {
            loadusers.value = interactor.loadAllUsers()
            }

    }

    fun signUpUsersBd(){
        viewModelScope.launch {
           usertoken.value = interactor.signUpUsersBd(name.value.toString(),username.value.toString()).toString()


        }


    }


}