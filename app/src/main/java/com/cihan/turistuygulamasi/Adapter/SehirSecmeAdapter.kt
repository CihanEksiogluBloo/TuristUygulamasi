package com.cihan.turistuygulamasi.Adapter

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cihan.turistuygulamasi.R
import com.cihan.turistuygulamasi.View.yonlendirmeBottomBar
import kotlinx.android.synthetic.main.recycler_row.view.*


class SehirSecmeAdapter(val sehirIsimListesi : List<String>): RecyclerView.Adapter<SehirSecmeAdapter.VH>() {
    class VH(itemViewz : View) : RecyclerView.ViewHolder(itemViewz) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val view2 = inflater.inflate(R.layout.recycler_row,parent,false)
        return VH(view2)

    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.ilAdiID.text = sehirIsimListesi[position]
        holder.itemView.setOnClickListener{
            var intent = Intent(holder.itemView.context, yonlendirmeBottomBar::class.java)
            intent.putExtra("province", sehirIsimListesi[position])
            holder.itemView.context.startActivity(intent)


        }


    }

    override fun getItemCount(): Int {
        return sehirIsimListesi.size
    }
}