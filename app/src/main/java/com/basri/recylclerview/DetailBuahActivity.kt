package com.basri.recylclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_buah.*
import kotlinx.android.synthetic.main.my_buah_view.view.*

class DetailBuahActivity : AppCompatActivity() {
        companion object{
            val CONSTANT_BUAH = "KEY_BUAH"
            val CONSTANT_MAKANAN= "KEY_MAKANAN"
            val CONSTANT_DESK = "KEY_DESK"
            val CONSTANT_IMAGE = "KEY_IMAGE"
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_buah)

        //menangakap datanya dan set pada textview
        tv_name_buah.text = intent.getStringExtra(CONSTANT_BUAH)
        tv_name_buah_deskripsi.text = intent.getStringExtra(CONSTANT_DESK)
        //tampilkan gambar
        Glide.with(this).load(
            intent.getStringExtra(CONSTANT_IMAGE))
            .error(R.drawable.no_img)
            .placeholder(R.drawable.ic_launcher_background)
            .into(img_buah);

    }
}