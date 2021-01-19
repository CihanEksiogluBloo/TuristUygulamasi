package com.cihan.turistuygulamasi.ViewModelAndFragments.ui.home

import android.content.Context
import android.widget.Toast

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cihan.turistuygulamasi.Model.Place
import com.google.firebase.firestore.FirebaseFirestore

class HomeViewModel : ViewModel() {

    val datalar = MutableLiveData<List<Place>>()
    val progressBar = MutableLiveData<Boolean>()

    var database = FirebaseFirestore.getInstance()











    fun verileriAl(context: Context,collectionPathName : String) {
        database.enableNetwork()
        database.collection(collectionPathName)
            .orderBy("Mekan")
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
                                var mekan = document.get("Mekan") as String
                                var tarih = document.get("Tarih") as String
                                var link: String? = document.get("link") as String

                                val verilistesi = ArrayList<Place>()
                                val indirilenVeri = Place(mekan,mekan,tarih,gorselurl,adres,link)
                                verilistesi.add(indirilenVeri)
                                datalar.value = verilistesi
                                progressBar.value = false
                                database.disableNetwork()


                            }


                        }
                    }
                }

            }

    }

}