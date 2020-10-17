package com.basri.recylclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.basri.recylclerview.DetailBuahActivity.Companion.CONSTANT_BUAH
import kotlinx.android.synthetic.main.my_text_view.view.*

class MyAdapter (private val myDataset: ArrayList<String>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val view: View) :
        RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_text_view, parent, false) as View

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return myDataset.size
       
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

        //action click
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.view.context,
                "data  ${myDataset[position]}",Toast.LENGTH_SHORT).show()

            //mengirim data ke actiivty lain
            val mengirimData = Intent(holder.itemView.context,
                    DetailBuahActivity::class.java
                )
            /// fungsi mengirim data menggunakan putextra param (key, data)
            mengirimData.putExtra(CONSTANT_BUAH,myDataset[position])
            holder.itemView.context.startActivity(mengirimData)

        }
        holder.view.tv_name_buah.text = myDataset[position]
       
    }


}