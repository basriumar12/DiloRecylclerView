package com.basri.recylclerview

import android.content.Intent
import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.basri.recylclerview.DetailBuahActivity.Companion.CONSTANT_BUAH
import com.basri.recylclerview.DetailBuahActivity.Companion.CONSTANT_DESK
import com.basri.recylclerview.DetailBuahActivity.Companion.CONSTANT_IMAGE
import com.basri.recylclerview.DetailBuahActivity.Companion.CONSTANT_MAKANAN
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.my_buah_view.view.*
import kotlinx.android.synthetic.main.my_text_view.view.*
import kotlinx.android.synthetic.main.my_text_view.view.tv_name_buah

class MyBuahAdapter (private val myDataset: MutableList<ModelBuah>) :
    RecyclerView.Adapter<MyBuahAdapter.MyViewHolder>() {
    class MyViewHolder(val view: View) :
        RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBuahAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_buah_view, parent, false) as View

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return myDataset.size
       
    }

    override fun onBindViewHolder(holder: MyBuahAdapter.MyViewHolder, position: Int) {

        //action click
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.view.context,
                "data  ${myDataset[position]}",Toast.LENGTH_SHORT).show()

            //mengirim data ke actiivty lain
            val mengirimData = Intent(holder.itemView.context,
                    DetailBuahActivity::class.java
                )
            /// fungsi mengirim data menggunakan putextra param (key, data)
            mengirimData.putExtra(CONSTANT_BUAH,myDataset[position].namaBuah)
            mengirimData.putExtra(CONSTANT_IMAGE,myDataset[position].imgBuah)
            mengirimData.putExtra(CONSTANT_DESK,myDataset[position].deskBuah)

            holder.itemView.context.startActivity(mengirimData)

        }
        holder.view.tv_name_buah.text = myDataset[position].namaBuah
        holder.view.tv_name_buah_deskripsi.text = myDataset[position].deskBuah
        Glide.with(holder.itemView.context).load(
            myDataset[position].imgBuah)
            .error(R.drawable.no_img)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.itemView.img_buah);
       
    }


}