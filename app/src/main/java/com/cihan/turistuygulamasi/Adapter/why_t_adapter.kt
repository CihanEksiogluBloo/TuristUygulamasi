package com.cihan.turistuygulamasi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cihan.turistuygulamasi.Model.Place
import com.cihan.turistuygulamasi.R
import kotlinx.android.synthetic.main.whyturkey_recycler_row.view.*

class why_t_adapter(val wtListe : ArrayList<String>, val wtListe2 : ArrayList<String>): RecyclerView.Adapter<why_t_adapter.wtVH>() {
    class wtVH(itemViewT: View) : RecyclerView.ViewHolder(itemViewT) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): wtVH {
        val infilater = LayoutInflater.from(parent.context)
        val view = infilater.inflate(R.layout.whyturkey_recycler_row,parent,false)
        return wtVH(view)
    }

    override fun onBindViewHolder(holder: wtVH, position: Int) {

        holder.itemView.wtText1.text = wtListe[position]
        holder.itemView.wtText2.text = wtListe2[position]





    }

    override fun getItemCount(): Int {
        return wtListe2.size
    }
}