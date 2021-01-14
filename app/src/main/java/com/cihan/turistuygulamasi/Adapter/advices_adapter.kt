package com.cihan.turistuygulamasi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cihan.turistuygulamasi.Model.Advice
import com.cihan.turistuygulamasi.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.advice_recyclerrow.view.*


class advices_adapter(val advicesList : ArrayList<Advice>) : RecyclerView.Adapter<advices_adapter.adviceVH>() {
    class adviceVH(adapterView : View) : RecyclerView.ViewHolder(adapterView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adviceVH {
        val infilater = LayoutInflater.from(parent.context)
        val view = infilater.inflate(R.layout.advice_recyclerrow,parent,false)
        return adviceVH(view)
    }

    override fun onBindViewHolder(holder: adviceVH, position: Int) {
        holder.itemView.adviceText.text = advicesList[position].adviceText
        Picasso.get().load(advicesList[position].adviceGorselUrl).into(holder.itemView.adviceGorsel)
    }

    override fun getItemCount(): Int {
        return advicesList.size
    }
    fun listeyiGuncelle(yeniliste : List<Advice>){
        advicesList.addAll(yeniliste)
        notifyDataSetChanged()

    }
}