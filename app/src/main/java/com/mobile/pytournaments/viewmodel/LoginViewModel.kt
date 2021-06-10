package com.mobile.pytournaments.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mobile.pytournaments.domain.Game
import com.mobile.pytournaments.domain.LoginResult
import com.mobile.pytournaments.domain.User
import com.mobile.pytournaments.interactor.LoginInteractor
import com.mobile.pytournaments.interactor.UserInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    app: Application,
    private val interactor: LoginInteractor
) : AndroidViewModel(app) {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val passwordCheck = MutableLiveData<String>()
    val loginResult = MutableLiveData<LoginResult>()


    val usertoken = MutableLiveData<String>()
    val signUpInfoName = MutableLiveData<String>()
    val signUpInfoUsername = MutableLiveData<String>()
    val signUpInfoPreferences = MutableLiveData<List<Game>>()

    fun login() {
        viewModelScope.launch {
            loginResult.value = interactor.login(email.value, password.value)
        }
    }

    fun signup() {
        viewModelScope.launch {
            loginResult.value = interactor.signUp(email.value, password.value, passwordCheck.value)
        }
    }

    fun forgot() {
        viewModelScope.launch {
            loginResult.value = interactor.forgotPassword(email.value)
        }
    }

}