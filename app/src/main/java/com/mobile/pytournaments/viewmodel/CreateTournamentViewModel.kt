package com.mobile.pytournaments.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mobile.pytournaments.domain.TournamentOnCreate
import com.mobile.pytournaments.interactor.TournamentInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.mobile.pytournaments.domain.Result
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CreateTournamentViewModel @Inject constructor(
    app: Application,
    private val interactor: TournamentInteractor
): AndroidViewModel(app){

    val result = MutableLiveData<Result>()
    val name = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    val checkboxValue = MutableLiveData<Boolean>()
    val date = MutableLiveData<String>()
    val time = MutableLiveData<String>()
    val lat = MutableLiveData<Double>()
    val lng = MutableLiveData<Double>()

    fun registerTournament(){
        viewModelScope.launch{
            result.value = interactor.registerTournament(name.value,description.value,
            date.value, time.value, lat.value, lng.value, checkboxValue.value!!)
        }
    }

    fun clickOnCheckbox(){
        when(checkboxValue.value) {
            true -> checkboxValue.value = false
            false -> checkboxValue.value = true
        }
    }


}