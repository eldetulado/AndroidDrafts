package com.example.androiddraft

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddraft.models.User

class DetailActivity : AppCompatActivity() {

    companion object {

        private const val PEOPLE: String = "people"

        fun newIntent(context: Context) {
            val intent = Intent(context, DetailActivity::class.java)
            context.startActivity(intent)
        }

        fun newUserIntent(context: Context, user: User) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(PEOPLE, user)
            context.startActivity(intent)
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val user: User? = intent.getParcelableExtra(PEOPLE)

        Log.e("DETAIL ACTIVITY", user.toString())
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}