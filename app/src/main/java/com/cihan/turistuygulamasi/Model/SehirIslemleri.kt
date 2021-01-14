package com.cihan.turistuygulamasi.Model

import androidx.lifecycle.ViewModel

class sehirIslemleri : ViewModel() {

    var sehirIsimleriListe = arrayListOf<String>()
    var sehirplakaListe = arrayListOf<Int>()
    var plakasayici = 1

    fun sehirekle(sehir : String){
        sehirIsimleriListe.add(sehir)
        sehirplakaListe.add(plakasayici)
        plakasayici+=1
    }


}