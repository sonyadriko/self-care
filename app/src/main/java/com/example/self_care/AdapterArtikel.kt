package com.example.self_care

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class AdapterArtikel(private val artikellist : ArrayList<Artikel>) : RecyclerView.Adapter<AdapterArtikel.MyViewHolder>() {

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val titleimage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val tvHeading : TextView = itemView.findViewById(R.id.tvHeading)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = artikellist[position]
        holder.titleimage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text = currentItem.heading
//        holder.itemView.setOnClickListener {
//            val intent = Intent(holder.itemView.context, ArtikelActivity::class.java)
//            holder.itemView.context.startActivity(intent)
//        }

    }

    override fun getItemCount(): Int {
        return artikellist.size
    }

    interface onAdapterListener{
        fun onclick()
    }



}