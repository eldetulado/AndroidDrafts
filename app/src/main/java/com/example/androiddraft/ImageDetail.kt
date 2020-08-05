package com.example.androiddraft

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_image_detail.*

class ImageDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)

        if (intent.extras != null) {
            Glide.with(this).load(intent.getStringExtra("imageUrl")).into(photo_view)
        }
    }
}