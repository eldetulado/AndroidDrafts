package com.example.androiddraft.domain.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androiddraft.User
import com.google.firebase.firestore.FirebaseFirestore

class Repo {
    fun getUserData(): LiveData<MutableList<User>> {
        val mutableData = MutableLiveData<MutableList<User>>()
        FirebaseFirestore.getInstance().collection("Usuarios").get().addOnSuccessListener {

            val listData = mutableListOf<User>()

            for (document in it) {
                val imageUrl = document.getString("imageUrl")
                val name = document.getString("name")
                val desc = document.getString("desc")

                val user = User(imageUrl!!, name!!, desc!!)

                listData.add(user)
            }

            mutableData.value = listData
        }

//        FirebaseFirestore.getInstance().collection("Usuarios").addSnapshotListener { value, e ->
//
//            val listData = mutableListOf<User>()
//
//            for(doc in value!!){
//                Log.e("REPO", doc.getString("name").toString())
//            }
//
//            mutableData.value = listData
//        }



        return mutableData
    }
}