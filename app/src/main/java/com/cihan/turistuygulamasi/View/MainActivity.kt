package com.cihan.turistuygulamasi.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.cihan.turistuygulamasi.R
import com.cihan.turistuygulamasi.ViewModelAndFragments.mainViewModel
import com.google.android.gms.ads.MobileAds
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()





    }
    fun startOnClick(view: View){
        val intent = Intent(applicationContext,SehirSecmeMain::class.java)
        startActivity(intent)
    }

    fun whyOnClick(view: View){
        val intent = Intent(applicationContext,why_turkey::class.java)
        startActivity(intent)

    }




}