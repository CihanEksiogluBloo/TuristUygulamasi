package com.cihan.turistuygulamasi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cihan.turistuygulamasi.Model.Food
import com.cihan.turistuygulamasi.Model.Place
import com.cihan.turistuygulamasi.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.foods_recycler_row.view.*
import kotlinx.android.synthetic.main.places_recycler_row.view.*

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
        holder.itemView.yemekRestoranID.text = yemeklistesi[position].restoran
        Picasso.get().load(yemeklistesi[position].resimUrl).into(holder.itemView.yemekGorselID)
    }

    override fun getItemCount(): Int {
        return yemeklistesi.size
    }
    fun listeyiGuncelle(yeniliste : List<Food>){
        yemeklistesi.addAll(yeniliste)
        notifyDataSetChanged()

    }
}