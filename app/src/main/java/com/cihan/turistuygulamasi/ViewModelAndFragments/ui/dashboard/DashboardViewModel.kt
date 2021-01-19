package com.cihan.turistuygulamasi.ViewModelAndFragments.ui.dashboard

import android.content.Context
import android.widget.Toast

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cihan.turistuygulamasi.Model.Food
import com.google.firebase.firestore.FirebaseFirestore

class DashboardViewModel : ViewModel() {
    val datalarFood = MutableLiveData<List<Food>>()
    val foodprogressBar = MutableLiveData<Boolean>()

    var database = FirebaseFirestore.getInstance()



    fun foodVerisiniAl(context: Context,collectionPathName : String) {
        database.enableNetwork()

        database.collection(collectionPathName)
                .orderBy("Yemek")
                .addSnapshotListener { snapshot, exception ->
                    if (exception != null){
                        Toast.makeText(context,exception.localizedMessage, Toast.LENGTH_LONG).show()
                        println(exception.localizedMessage)
                    }else{
                        if (snapshot != null){
                            if (!snapshot.isEmpty){

                                val documents = snapshot.documents

                                for (document in documents){


                                    var adres = document.get("Adres") as String
                                    var gorselurl = document.get("GorselUrl") as String
                                    var bilgi = document.get("Bilgi") as String
                                    var restoran = document.get("Restoran") as String
                                    var yemekadi = document.get("Yemek") as String
                                    var kaynak = document.get("Kaynak") as String

                                    val verilistesi = ArrayList<Food>()
                                    val indirilenVeri = Food(restoran,yemekadi,bilgi,gorselurl,adres,kaynak)
                                    verilistesi.add(indirilenVeri)
                                    datalarFood.value = verilistesi
                                    foodprogressBar.value = false
                                    database.disableNetwork()

                                }


                            }
                        }
                    }
                }

    }
}






