package com.cihan.turistuygulamasi.ViewModelAndFragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class yonlendirmeViewModel(application: Application) : AndroidViewModel(application) {

    val someChangingVar = MutableLiveData<String>() //typically private and exposed through method

    fun placeSearchFun(newString: String) {
        someChangingVar.value = newString
    }




}