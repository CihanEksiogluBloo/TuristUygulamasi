package com.cihan.turistuygulamasi.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cihan.turistuygulamasi.Adapter.SehirSecmeAdapter
import com.cihan.turistuygulamasi.R
import com.cihan.turistuygulamasi.Model.sehirIslemleri
import kotlinx.android.synthetic.main.activity_sehir_secme_main.*

class SehirSecmeMain : AppCompatActivity() {
    val sehirislemleri = sehirIslemleri()

    private lateinit var recyclerviewAdater: SehirSecmeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sehir_secme_main)


        sehirekle81()
        val sehirPlakaListesi = sehirislemleri.sehirplakaListe
        val sehirIsimListesi = sehirislemleri.sehirIsimleriListe.sortedBy { it}
        var layoutManager = LinearLayoutManager(this)
        recyclerViewID.layoutManager = layoutManager
        recyclerviewAdater = SehirSecmeAdapter(sehirIsimListesi,sehirPlakaListesi)
        recyclerViewID.adapter = recyclerviewAdater




    }
    fun sehirekle81(){
        sehirislemleri.sehirekle("Adana")
        sehirislemleri.sehirekle("Adıyaman")
        sehirislemleri.sehirekle("Afyonkarahisar")
        sehirislemleri.sehirekle("Ağrı")
        sehirislemleri.sehirekle("Amasya")
        sehirislemleri.sehirekle("Ankara")
        sehirislemleri.sehirekle("Antalya")
        sehirislemleri.sehirekle("Artvin")
        sehirislemleri.sehirekle("Aydın")
        sehirislemleri.sehirekle("Balıkesir")
        sehirislemleri.sehirekle("Bilecik")
        sehirislemleri.sehirekle("Bingöl")
        sehirislemleri.sehirekle("Bitlis")
        sehirislemleri.sehirekle("Bolu")
        sehirislemleri.sehirekle("Burdur")
        sehirislemleri.sehirekle("Bursa")
        sehirislemleri.sehirekle("Canakkale")
        sehirislemleri.sehirekle("Cankırı")
        sehirislemleri.sehirekle("Corum")
        sehirislemleri.sehirekle("Denizli")
        sehirislemleri.sehirekle("Diyarbakır")
        sehirislemleri.sehirekle("Edirne")
        sehirislemleri.sehirekle("Elazığ")
        sehirislemleri.sehirekle("Erzincan")
        sehirislemleri.sehirekle("Erzurum")
        sehirislemleri.sehirekle("Eskişehir")
        sehirislemleri.sehirekle("Gaziantep")
        sehirislemleri.sehirekle("Giresun")
        sehirislemleri.sehirekle("Gümüşhane")
        sehirislemleri.sehirekle("Hakkâri")
        sehirislemleri.sehirekle("Hatay")
        sehirislemleri.sehirekle("Isparta")
        sehirislemleri.sehirekle("Mersin")
        sehirislemleri.sehirekle("Istanbul")
        sehirislemleri.sehirekle("Izmir")
        sehirislemleri.sehirekle("Kars")
        sehirislemleri.sehirekle("Kastamonu")
        sehirislemleri.sehirekle("Kayseri")
        sehirislemleri.sehirekle("Kırklareli")
        sehirislemleri.sehirekle("Kırşehir")
        sehirislemleri.sehirekle("Kocaeli")
        sehirislemleri.sehirekle("Konya")
        sehirislemleri.sehirekle("Kütahya")
        sehirislemleri.sehirekle("Malatya")
        sehirislemleri.sehirekle("Manisa")
        sehirislemleri.sehirekle("Kahramanmaraş")
        sehirislemleri.sehirekle("Mardin")
        sehirislemleri.sehirekle("Muğla")
        sehirislemleri.sehirekle("Muş")
        sehirislemleri.sehirekle("Nevşehir")
        sehirislemleri.sehirekle("Niğde")
        sehirislemleri.sehirekle("Ordu")
        sehirislemleri.sehirekle("Rize")
        sehirislemleri.sehirekle("Sakarya")
        sehirislemleri.sehirekle("Samsun")
        sehirislemleri.sehirekle("Siirt")
        sehirislemleri.sehirekle("Sinop")
        sehirislemleri.sehirekle("Sivas")
        sehirislemleri.sehirekle("Tekirdağ")
        sehirislemleri.sehirekle("Tokat")
        sehirislemleri.sehirekle("Trabzon")
        sehirislemleri.sehirekle("Tunceli")
        sehirislemleri.sehirekle("Sanlıurfa")
        sehirislemleri.sehirekle("Uşak")
        sehirislemleri.sehirekle("Van")
        sehirislemleri.sehirekle("Yozgat")
        sehirislemleri.sehirekle("Zonguldak")
        sehirislemleri.sehirekle("Aksaray")
        sehirislemleri.sehirekle("Bayburt")
        sehirislemleri.sehirekle("Karaman")
        sehirislemleri.sehirekle("Kırıkkale")
        sehirislemleri.sehirekle("Batman")
        sehirislemleri.sehirekle("Sırnak")
        sehirislemleri.sehirekle("Bartın")
        sehirislemleri.sehirekle("Ardahan")
        sehirislemleri.sehirekle("Iğdır")
        sehirislemleri.sehirekle("Yalova")
        sehirislemleri.sehirekle("Karabük")
        sehirislemleri.sehirekle("Kilis")
        sehirislemleri.sehirekle("Osmaniye")
        sehirislemleri.sehirekle("Düzce")}
}