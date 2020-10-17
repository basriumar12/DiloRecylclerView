package com.basri.recylclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var dataBuah = arrayListOf<String>(
            "Buah Mangga",
            "Buah Apel",
            "Buah Durian",
            "Buah Alpukat",
            "Buah Nangka",
            "Buah Manggis",
            "Buah Kelapa",
            "Buah Mangga",
            "Buah Apel",
            "Buah Durian",
            "Buah Alpukat",
            "Buah Nangka",
            "Buah Manggis",
            "Buah Kelapa",
            "Buah Naga"
    )


    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         //non grid
        //viewManager = LinearLayoutManager(this)
        //grid
        viewManager = GridLayoutManager(this,2)
        viewAdapter = MyAdapter(dataBuah)
        rv_data_buah.setHasFixedSize(true)
        rv_data_buah.layoutManager = viewManager
        //untuk set data recyclerview
        rv_data_buah.adapter = viewAdapter



    }
}