package com.example.androiddraft.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androiddraft.R
import com.example.androiddraft.ui.modelo.Frutas
import com.example.androiddraft.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpViewModel()

        btnCrearListFrutas.setOnClickListener {
            viewModel.getListaFrutas()
        }
    }

    fun setUpViewModel() {
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        val frutasObserver = Observer<List<Frutas>> {
            for (fruta in it) {
                Log.d("Frutas:", fruta.toString())
            }
        }

        viewModel.getListFrutasLiveData().observe(this, frutasObserver)
    }
}