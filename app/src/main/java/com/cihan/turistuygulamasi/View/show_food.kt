package com.cihan.turistuygulamasi.View

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cihan.turistuygulamasi.Model.darkbackground
import com.cihan.turistuygulamasi.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_show_food.*
import kotlinx.android.synthetic.main.activity_show_places.*

class show_food : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_food)



        val intent = intent
        val yemekIsmiSF = intent.getStringExtra("yemekIsmiValue")
        val BilgiSF = intent.getStringExtra("BilgiValue")
        val restoranSF = intent.getStringExtra("restoranValue")
        val adresSF = intent.getStringExtra("adresValue")
        val kaynakSF = intent.getStringExtra("kaynakValue")
        val resimUrlSF = intent.getStringExtra("resimUrlValue")




        val dbg = darkbackground()
        dbg.darkBGforActivity(applicationContext,window,supportActionBar)


        Picasso.get().load(resimUrlSF).into(showFoodImageID)
        showFoodHeader.text = yemekIsmiSF
        showFoodText.text = BilgiSF
        showFoodSource.text = kaynakSF
        showFoodRestoran.text = restoranSF


        if(adresSF == "NoGeo"){
            showFoodButtonID.setBackgroundColor(Color.GRAY)
            showFoodButtonID.text = "No Restoran"
            showFoodRestoran.text = "TR: Eğer Bu yemeği temsil eden restoran olmak istiyorsanız, \n iletişime geçin: BlooApplication@gmail.com\n " +
                    "\n ENG: If you want to be the restaurant that represents this dish, \n contact us: BlooApplication@gmail.com"


        }else{


        showFoodButtonID.setOnClickListener {
            val gmmIntentUri = Uri.parse(adresSF)
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            it.context.startActivity(mapIntent)
        }}

    }
}