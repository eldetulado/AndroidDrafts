package com.example.androiddraft

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddraft.modelo.Animal
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerAdapter.OnAnimalClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        val listAnimals = listOf(
            Animal(
                "Perro",
                "https://estaticos.muyinteresante.es/media/cache/760x570_thumb/uploads/images/article/5c3871215bafe83b078adbe3/perro.jpg"
            ),
            Animal(
                "Gato",
                "https://estaticos.muyinteresante.es/media/cache/760x570_thumb/uploads/images/article/5c3871215bafe83b078adbe3/perro.jpg"
            ),
            Animal(
                "Loro",
                "https://estaticos.muyinteresante.es/media/cache/760x570_thumb/uploads/images/article/5c3871215bafe83b078adbe3/perro.jpg"
            )
        )

        recyclerView.adapter = RecyclerAdapter(this, listAnimals, this)
    }

    override fun onImageClick(imagen: String) {
        Toast.makeText(this, imagen, Toast.LENGTH_LONG).show()
        val intent = Intent(this, ImageDetail::class.java)
        intent.putExtra("imageUrl", imagen)
        startActivity(intent)
    }

    override fun onItemClick(nombre: String) {
        Toast.makeText(this, nombre, Toast.LENGTH_LONG).show()
    }
}