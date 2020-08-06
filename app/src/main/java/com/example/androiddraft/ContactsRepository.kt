package com.example.androiddraft

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androiddraft.models.Contact

class ContactsRepository(application: Application) {
    private val contactDao: ContactDao? = ContactsDatabase.getInstance(application)?.contactDato()

    fun insert(contact: Contact) {
        if (contactDao != null){
            InsertAsyncTask(contactDao).execute(contact)
        }
    }

    fun getContacts(): LiveData<List<Contact>>{
        return contactDao?.getOrderedAgenda() ?: MutableLiveData<List<Contact>>()
    }

    private class InsertAsyncTask(private val contactDao: ContactDao) :
        AsyncTask<Contact, Void, Void>() {
        override fun doInBackground(vararg params: Contact?): Void? {
            for(contact in params){
                if(contact != null) contactDao.insert(contact)
            }
            return null
        }

    }
}