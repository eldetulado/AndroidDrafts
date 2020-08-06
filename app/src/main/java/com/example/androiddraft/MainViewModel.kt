package com.example.androiddraft

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> get() = _loginResult


    fun onSubmitClick(user: String, pass: String) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                validateLogin(user, pass)
            }
            _loginResult.value = result
        }
    }

    private fun validateLogin(user: String, pass: String): Boolean {
        Thread.sleep(2000L)
        return user.isNotEmpty() && pass.isNotEmpty()
    }
}