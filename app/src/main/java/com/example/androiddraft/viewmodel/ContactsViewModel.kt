package com.example.androiddraft.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.androiddraft.ContactsRepository
import com.example.androiddraft.models.Contact

class ContactsViewModel(application: Application): AndroidViewModel(application) {
    private val repository = ContactsRepository(application)

    val contacts = repository.getContacts()

    fun saveContact(contact: Contact){
        repository.insert(contact)
    }
}