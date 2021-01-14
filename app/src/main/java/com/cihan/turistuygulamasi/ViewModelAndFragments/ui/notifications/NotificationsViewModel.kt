package com.cihan.turistuygulamasi.ViewModelAndFragments.ui.notifications

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cihan.turistuygulamasi.Model.Advice
import com.google.firebase.firestore.FirebaseFirestore

class NotificationsViewModel : ViewModel() {
    val datalar = MutableLiveData<List<Advice>>()
    val progressBar = MutableLiveData<Boolean>()

    var database = FirebaseFirestore.getInstance()


    fun adviceVerileriAl(context: Context,collectionPathName : String) {

        database.collection(collectionPathName)
                .orderBy("Advices")
                .addSnapshotListener { snapshot, exception ->
                    if (exception != null){
                        Toast.makeText(context,exception.localizedMessage, Toast.LENGTH_LONG).show()
                        println(exception.localizedMessage)
                    }else{
                        if (snapshot != null){
                            if (!snapshot.isEmpty){

                                val documents = snapshot.documents

                                for (document in documents){

                                    var advice = document.get("Advices") as String
                                    var gorselurl = document.get("GorselUrl") as String
                                    val verilistesi = ArrayList<Advice>()
                                    val indirilenVeri = Advice(advice,gorselurl)
                                    verilistesi.add(indirilenVeri)
                                    datalar.value = verilistesi
                                    progressBar.value = false

                                }


                            }
                        }
                    }
                }

    }

}