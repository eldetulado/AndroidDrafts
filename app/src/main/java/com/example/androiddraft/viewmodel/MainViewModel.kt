package com.example.androiddraft.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddraft.User
import com.example.androiddraft.domain.data.network.Repo

class MainViewModel: ViewModel() {

    private val repo = Repo()

    fun fetchUserData(): LiveData<MutableList<User>>{
        val mutableData = MutableLiveData<MutableList<User>>()
        repo.getUserData().observeForever {
            mutableData.value = it
        }

        return mutableData
    }
}