package com.example.androiddraft

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddraft.models.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = User(1, "Juan", "Perez", 23)

        btnSendData.setOnClickListener {
            DetailActivity.newUserIntent(this, user)
        }
    }
}