package com.cihan.turistuygulamasi.Model

import androidx.lifecycle.ViewModel

class sehirIslemleri : ViewModel() {

    var sehirIsimleriListe = arrayListOf<String>()

    fun sehirekle(sehir : String){
        sehirIsimleriListe.add(sehir)
    }


}