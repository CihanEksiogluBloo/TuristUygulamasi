package com.cihan.turistuygulamasi.View


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cihan.turistuygulamasi.Adapter.why_t_adapter
import com.cihan.turistuygulamasi.R
import kotlinx.android.synthetic.main.activity_sehir_secme_main.*
import kotlinx.android.synthetic.main.activity_why_turkey.*


class why_turkey : AppCompatActivity() {
    private lateinit var recyclerviewAdapterWT: why_t_adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_why_turkey)
        supportActionBar?.hide()

        var reasons = arrayListOf<String>()
        var reasons2 = arrayListOf<String>()
        reasons.add("It is a country that connects the continents of Europe, Asia and Africa.\n" +
                "Turkey is the center of the world. It can fly to almost everywhere directly from Istanbul.\n" +
                "Istanbul connects the Asian and European continents.\n" +
                "Istanbul has been the capital of ancient states such as Rome, Byzantine and Ottoman.\n")
        reasons2.add("Probably the currency you use is worth more than the Turkish lira. This value is an inevitable opportunity for tourists. \n" +
                "The living standards for tourists are very high. Turkey world's 6th most-visited country. In Turkey is a quality meal for \$ 3-4 range.\n")
        reasons.add("It is a well-known mistake that Turkish culture is like Arab culture . Turks use the Latin alphabet . Turkish language is spoken. \n" +
                "The most spoken foreign language is English. It is given as a compulsory course in schools. But English is not spoken in small parts of the country.\n")
        reasons2.add("Turkish desserts are very popular. Ashura Hz. It is referred to as Noah 's pudding and is the oldest dessert in the world.\n" +
                "Picasso has his works almost every day Turkish Delight .\n" +
                "Most of the tourists said about the first mention of Turkey , the dish that it is very tasty.\n")
        reasons.add("Turks have introduced coffee to Europe.\n" +
                "When tulips produced in the Ottoman Empire were sent to the Netherlands, tulip bulbs were started to be produced in the Netherlands.\n" +
                "A cultural part of the country is street animals. Cats and dogs can roam the streets freely. Animals are humane.\n")
        reasons2.add("Turks have animal hospitals and animal ambulances for animals.\n" +
                "Turks can come together for a single purpose despite all kinds of differences and differences of opinion.\n" +
                "It is possible to see the Turkish flag all over the country . About this situation\n")
        reasons.add("One of the most surprising points for tourists is hospitality.\n" +
                "According to the report published in Switzerland , Istanbul is the most hospitable city in Europe . ( Basel Public and Economic Institute 2019)\n")
        reasons2.add("In traditional Turkish houses, halls are used when guests come, people used to spend time in what they call living rooms. \n" +
                "Special items such as tableware and bed linen are reserved for guests in the houses. \n")
        reasons.add("The houses are not entered with shoes. Slippers are put on for guests as soon as they enter the door. Special towels are brought for the guests.")
        reasons2.add("The tables for the guests are equipped with the best meals. Valuable meals that are not often cooked in daily life are made. It is a unique culture like no other in the world.\n" +
                "People are friendly and helpful.\n" +
                "Turkey politics is very dynamic. People don't like talking about these things very much.\n")
        reasons.add("The fact that you do not finish the meal on your plate creates the perception that you do not like your meal.\n" +
                "Although it is generally found in rural areas, Turkish men generally speak to men.\n" +
                "If you come as a male and female couple, a Turkish man usually communicates with the man.\n")
        reasons2.add("If you are a man; It wouldn't look nice if you talk to women directly. They are thought that you can disturb women.\n" +
                " They don't prefer you to ask questions to young and single women. It seems more appropriate to ask questions to men.\n")
        reasons.add("Turkey has been one of the country attaches importance to equality between men and women.\n" +
                "Turkey is one of the countries that give women the right to vote and be elected for the first time. Women got this right earlier than women in Europe.\n")
        reasons2.add("Turkey on the UNESCO World Heritage List has 18 places. It has 83 places in the temporary list.\n" +
                "486 beaches in the country were awarded the blue flag. This flag is awarded for the most beautiful and cleanest beaches.\n" +
                "The first writing marks which the found first human-made have been found in Turkey.\n")
        reasons.add("The first human-made paintings on the wall were discovered in Çatalhöyük, Konya, the first known settlement in human history. \n" +
                "Turkiye has 2 world's wonders out of the 7 wonders.\n" +
                "The Temple of Artemis in Izmir and the Halicarnassus Mausoleum in Muğla.\n")
        reasons2.add("Istanbul Kapalıçarşı, one of the oldest and largest markets in the world. Istanbul has the oldest underground railroad after London.\n" +
                "As one of the few countries that Turkey's agricultural self-sufficiency. fruits or vegetables that your consume in Turkey are probably grown in Turkey\n" +
                "Approximately 75% of the world's hazelnuts from Turkey are met.\n")
        reasons.add("It is the world leader producer of Hazelnut, Apricot, Fig, Cherry.\n" +
                "Turkey known for cotton, sunflower, legumes, grapes, apples, dried fruits, animal husbandry.\n" +
                "1 in 3 of the 9000 endemic plant species in Turkey. So they can only live in this country.\n")
        reasons2.add("Soil variety and fertility is very high. A different kind of plant is discovered every 10 days.\n" +
                "Spiritual leaders of 300,000,000 Orthodox live in Istanbul.\n" +
                "7 churches of revelation written in the Bible are in these lands.\n" +
                "There are a lot of false information has been made about Turkey.\n")
        reasons.add("The country allows for dual citizenship. Turkey’s citizenship is one of the cheapest citizenships in the world.\n" +
                "There is freedom of dress in Turkey.  Men do not prefer to wear fez since 1925.\n" +
                "There are no camels in the country. There may be companies importing, but you cannot come across\n")
        reasons2.add("Mustafa Kemal Atatürk")

        wtClickToView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=416Z-cr1kJg"))
            startActivity(browserIntent)
        }






        var layoutManager = LinearLayoutManager(this)
        wtRecyclerViewID.layoutManager = layoutManager
        recyclerviewAdapterWT = why_t_adapter(reasons, reasons2)
        wtRecyclerViewID.adapter = recyclerviewAdapterWT




    }
}