package com.example.androiddraft.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddraft.MainAdapter
import com.example.androiddraft.R
import com.example.androiddraft.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        adapter = MainAdapter(this)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        observeData()


    }

    fun observeData() {
        shimmerView.startShimmer()
        viewModel.fetchUserData().observe(this, Observer {
            shimmerView.visibility = View.GONE
            shimmerView.stopShimmer()
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })


    }
}