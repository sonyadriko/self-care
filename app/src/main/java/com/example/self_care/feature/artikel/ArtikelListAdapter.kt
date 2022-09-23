package com.example.self_care.feature.artikel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.self_care.R
import com.example.self_care.domain.Artikel
import com.github.core.common.listener.OnClickListener
import com.google.android.material.imageview.ShapeableImageView

class ArtikelListAdapter(
    private val artikellist: ArrayList<Artikel>,
    private val onClickListener: OnClickListener
) :
    RecyclerView.Adapter<ArtikelListAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleimage: ShapeableImageView = itemView.findViewById(R.id.title_image)
        val tvHeading: TextView = itemView.findViewById(R.id.tvHeading)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = artikellist[position]
        holder.titleimage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text = currentItem.heading

        holder.itemView.setOnClickListener {
            onClickListener.onClick(
                data = currentItem,
                position = position
            )
        }
    }

    override fun getItemCount(): Int {
        return artikellist.size
    }
}