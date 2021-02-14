package com.cihan.turistuygulamasi.ViewModelAndFragments

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.graphics.drawable.ColorDrawable
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.cihan.turistuygulamasi.R

class yonlendirmeViewModel(application: Application) : AndroidViewModel(application) {

    val someChangingVar = MutableLiveData<String>() //typically private and exposed through method

    fun placeSearchFun(newString: String) {
        someChangingVar.value = newString
    }
    fun darkBG(context: Context, window: Window, supportActionBar: androidx.appcompat.app.ActionBar?) {
        val mode = context?.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)
        when (mode) {
            Configuration.UI_MODE_NIGHT_YES -> {
                window.statusBarColor = ContextCompat.getColor(context, R.color.black)
                supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(context, R.color.systemDarkGrey)))
            }
            //Configuration.UI_MODE_NIGHT_NO -> {}
            //Configuration.UI_MODE_NIGHT_UNDEFINED -> {}
        }
    }




}