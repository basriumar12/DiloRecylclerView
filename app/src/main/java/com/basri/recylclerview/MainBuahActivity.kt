package com.basri.recylclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main_buah.*

class MainBuahActivity : AppCompatActivity() {

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_buah)

        viewManager = GridLayoutManager(this, 1)
        val dataBuahList: MutableList<ModelBuah> = ArrayList()

        val data = ModelBuah(
            "Buah Mangga",
            "https://fitshop-prodion.s3.ap-southeast-1.amazonaws.com/wp-content/uploads/2020/06/30222005/Mangga-Harum-Manis.jpg"
            , "Ini deskripsi mangga"
        )

        dataBuahList.add(data)
        dataBuahList.add(
            ModelBuah(
                "Buah Durian",
              "https://asset.kompas.com/crops/jglhOjivGnsycy3U10Q9zl2mFow=/0x39:676x490/750x500/data/photo/2020/02/20/5e4e5b40c6428.jpg"
                , "Ini deskripsi Durian"
            )
        )


        dataBuahList.add(
            ModelBuah(
                "Buah Naga",
                "https://fitshop-production.s3.ap-southeast-1.amazonaws.com/wp-content/uploads/2020/06/30222005/Mangga-Harum-Manis.jpg"
                , "Ini deskripsi Naga"
            )

        )

        dataBuahList.add(
            ModelBuah(
                "Buah Nangka",
                "https://ecs7.tokopedia.net/img/cache/700/product-1/2018/7/21/3608858/3608858_0994d492-26c9-450f-a4e5-aa6df4713930_433_340.jpg"                , "Ini deskripsi Nangka"
            )

        )

        viewAdapter = MyBuahAdapter(dataBuahList)
        rv_data_buah2.setHasFixedSize(true)
        rv_data_buah2.layoutManager = viewManager
        rv_data_buah2.adapter = viewAdapter
    }
}