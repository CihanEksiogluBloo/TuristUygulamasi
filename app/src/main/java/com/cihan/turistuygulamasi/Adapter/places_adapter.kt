package com.cihan.turistuygulamasi.Adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cihan.turistuygulamasi.Model.Place
import com.cihan.turistuygulamasi.R
import com.cihan.turistuygulamasi.View.show_places
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.places_recycler_row.view.*

class places_adapter(val verilistesi : ArrayList<Place>): RecyclerView.Adapter<places_adapter.VH>() {
    class VH(viewz : View) : RecyclerView.ViewHolder(viewz) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val infilater = LayoutInflater.from(parent.context)
        val view = infilater.inflate(R.layout.places_recycler_row,parent,false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        holder.itemView.nameViewID.text = verilistesi[position].mekanAdi
        holder.itemView.historyViewID.text = verilistesi[position].mekanTarih
        Picasso.get().load(verilistesi[position].gorselUrl).into(holder.itemView.placesImageViewID)
        holder.itemView.butonViewID.setOnClickListener{

            val context= holder.itemView.context

            val gmmIntentUri = Uri.parse(verilistesi.get(position).adres)
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            context.startActivity(mapIntent)

        }
        holder.itemView.placesGlobalLayout.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context,show_places::class.java)
            intent.putExtra("gorselValue",verilistesi[position].gorselUrl)
            intent.putExtra("mekanAdiValue",verilistesi[position].mekanAdi)
            intent.putExtra("mekanTarihValue",verilistesi[position].mekanTarih)
            intent.putExtra("adresValue",verilistesi[position].adres)
            intent.putExtra("linkValue",verilistesi[position].link)


            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return verilistesi.size
    }
    fun listeyiGuncelle(yeniliste : List<Place>){
        verilistesi.addAll(yeniliste)
        notifyDataSetChanged()

    }

}