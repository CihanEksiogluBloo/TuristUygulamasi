package com.cihan.turistuygulamasi.Adapter

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cihan.turistuygulamasi.Model.Food
import com.cihan.turistuygulamasi.R
import com.cihan.turistuygulamasi.View.show_food
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.foods_recycler_row.view.*

class food_adapter(var yemeklistesi : ArrayList<Food>) : RecyclerView.Adapter<food_adapter.foodadapter>() {
    class foodadapter(viewz : View) : RecyclerView.ViewHolder(viewz) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): foodadapter {
        val infilater = LayoutInflater.from(parent.context)
        val view = infilater.inflate(R.layout.foods_recycler_row,parent,false)
        return foodadapter(view)
    }

    override fun onBindViewHolder(holder: foodadapter, position: Int) {
        holder.itemView.yemekAdiID.text = yemeklistesi[position].yemekIsmi
        holder.itemView.yemekBilgiID.text = yemeklistesi[position].Bilgi
        holder.itemView.foodRestoranTextID.text = yemeklistesi[position].restoran
        holder.itemView.kaynakFoodID.text = yemeklistesi[position].kaynak
        Picasso.get().load(yemeklistesi[position].resimUrl).into(holder.itemView.yemekGorselID)

        if(yemeklistesi[position].adres == "NoGeo"){
            holder.itemView.foodRCButtonID.setBackgroundColor(Color.GRAY)
            holder.itemView.foodRCButtonID.text = "No Restoran"
            holder.itemView.foodRestoranTextID.text = " for representation \n iletişime geçin / contact us:\n BlooApplication@gmail.com "


        }else{
        holder.itemView.foodRCButtonID.setOnClickListener{

            val context= holder.itemView.context

            val gmmIntentUri = Uri.parse(yemeklistesi.get(position).adres)
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            context.startActivity(mapIntent)}

        }

        holder.itemView.foodGlobalLayout.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, show_food::class.java)
            intent.putExtra("yemekIsmiValue",yemeklistesi[position].yemekIsmi)
            intent.putExtra("BilgiValue",yemeklistesi[position].Bilgi)
            intent.putExtra("restoranValue",yemeklistesi[position].restoran)
            intent.putExtra("adresValue",yemeklistesi[position].adres)
            intent.putExtra("kaynakValue",yemeklistesi[position].kaynak)
            intent.putExtra("resimUrlValue",yemeklistesi[position].resimUrl)


            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return yemeklistesi.size
    }
    fun listeyiGuncelle(yeniliste : List<Food>){
        yemeklistesi.addAll(yeniliste)
        notifyDataSetChanged()

    }
}