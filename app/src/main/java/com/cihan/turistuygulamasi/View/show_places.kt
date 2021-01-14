package com.cihan.turistuygulamasi.View

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

import com.cihan.turistuygulamasi.R
import com.cihan.turistuygulamasi.ViewModelAndFragments.ShowViewModel
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_show_places.*


class show_places : AppCompatActivity() {
    private lateinit var viewModel : ShowViewModel
    private var adres = ""

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_places)

        val intent = intent
        val gorselshow = intent.getStringExtra("gorselValue")
        showBaslikID.text = intent.getStringExtra("mekanAdiValue")
        showBilgiTextID.text = intent.getStringExtra("mekanTarihValue")
        adres = intent.getStringExtra("adresValue").toString()
        val link = intent.getStringExtra("linkValue")

        Picasso.get().load(gorselshow).into(showGorselID)


        viewModel = ViewModelProvider(this).get(ShowViewModel::class.java)

        showButtonID.setOnClickListener {
            val gmmIntentUri = Uri.parse(adres)
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        showInf.setOnClickListener {
            val link = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(link)
        }


        }






    }



