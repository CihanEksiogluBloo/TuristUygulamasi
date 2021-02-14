package com.cihan.turistuygulamasi.Model

import android.app.ActionBar
import android.content.Context
import android.content.res.Configuration
import android.graphics.drawable.ColorDrawable
import android.view.Window
import androidx.core.content.ContextCompat
import com.cihan.turistuygulamasi.R

class darkbackground() {

    fun darkBGforActivity(context : Context,window : Window, supportActionBar: androidx.appcompat.app.ActionBar? ){
        val mode = context?.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)
        when (mode) {
            Configuration.UI_MODE_NIGHT_YES -> { window.statusBarColor = ContextCompat.getColor(context, R.color.black)
                supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(context, R.color.systemDarkGrey)))
            }
            //Configuration.UI_MODE_NIGHT_NO -> {}
            //Configuration.UI_MODE_NIGHT_UNDEFINED -> {}
        }

    }


}