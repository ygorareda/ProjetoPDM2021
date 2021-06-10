package com.mobile.pytournaments.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import java.util.*
import javax.inject.Inject

class SharedViewModel @Inject constructor(
    app: Application
    ): AndroidViewModel(app)  {
    private val selected = MutableLiveData<Any>()

    fun selectItem(obj : Any){
        selected.value = obj
    }

    fun getSelectedItem() = selected.value
}