package com.mobile.pytournaments.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mobile.pytournaments.domain.Game
import com.mobile.pytournaments.domain.User
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

    val loadusers = MutableLiveData<List<UserCadastraApi>>()
    val usertoken = MutableLiveData<String>()
    val uniqueUser = MutableLiveData<UserCadastraApi>()
    val id = MutableLiveData<Int>()
    val name = MutableLiveData<String>()
    val username = MutableLiveData<String>()
    var teste: String = ""

    val signUpInfoPreferences = MutableLiveData<List<Game>>()

    fun loadAllFriends(){
        viewModelScope.launch {
            loadusers.value = interactor.loadAllFriends()
            }

    }

    fun signUpUsersBd(){

        viewModelScope.launch {
            Log.d("teste",name.value.toString())
            Log.d("teste", username.value.toString())
            usertoken.value = interactor.signUpUsersBd(name.value.toString(),username.value.toString())


        }
    }

   fun loadUniqueUser() {

        viewModelScope.launch {
            //Log.d("teste",usertoken.value.toString())
            //Log.d("teste", teste.toString())
            uniqueUser.value = interactor.loadUniqueUser()
            //Log.d("teste", uniqueUser.value.toString())
            

        }
    }

    fun getLoggedUser() = User(id.value!!, name.value!!, username.value!!, "", "")

}