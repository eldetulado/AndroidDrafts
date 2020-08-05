package com.example.androiddraft

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row.view.*

class MainAdapter(
    private val context: Context
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var listUsers = mutableListOf<User>()

    fun setListData(data: MutableList<User>) {
        listUsers = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (listUsers.size > 0) listUsers.size else 0
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindView(listUsers[position])
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(user: User) {
            Glide.with(context).load(user.imageUrl).into(itemView.circleImageView)
            itemView.txt_title.text = user.name
            itemView.txt_desc.text = user.desc
        }
    }
}