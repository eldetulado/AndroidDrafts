package com.example.androiddraft

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androiddraft.base.BaseViewHolder
import com.example.androiddraft.modelo.Animal
import kotlinx.android.synthetic.main.animales_row.view.*

class RecyclerAdapter(
    private val context: Context,
    private val listAnimals: List<Animal>,
    private val itemClickListener: OnAnimalClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnAnimalClickListener {
        fun onImageClick(imagen: String)
        fun onItemClick(nombre: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return AnimalsViewHolder(
            LayoutInflater.from(context).inflate(R.layout.animales_row, parent, false)
        )
    }

    override fun getItemCount(): Int = listAnimals.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is AnimalsViewHolder -> holder.bind(listAnimals[position], position)
            else -> throw IllegalArgumentException("View Holder not defined")
        }
    }

    inner class AnimalsViewHolder(itemView: View) : BaseViewHolder<Animal>(itemView) {
        override fun bind(item: Animal, position: Int) {

            itemView.setOnClickListener {
                itemClickListener.onItemClick(item.nombre)
            }

            itemView.img_animal.setOnClickListener {
                itemClickListener.onImageClick(item.imagen)
            }

            Glide.with(context).load(item.imagen).into(itemView.img_animal)
            itemView.txt_name_animal.text = item.nombre
        }

    }
}