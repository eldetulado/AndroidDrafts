package com.example.androiddraft

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androiddraft.models.Contact
import com.example.androiddraft.viewmodel.ContactsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var contactsViewModel: ContactsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactsViewModel = ViewModelProvider(this).get(ContactsViewModel::class.java)

        addContact_button.setOnClickListener {
            addContact()
        }

        addObserver()

    }

    private fun addObserver() {
        val observer = Observer<List<Contact>> { contacts ->
            if (contacts != null) {
                var text = ""
                for (contact in contacts) {
                    text += contact.lastName + " " + contact.firstName + " - " + contact.phoneNumber + "\n"
                }
                contacts_textView.text = text
            }
        }
        contactsViewModel.contacts.observe(this, observer)
    }

    private fun addContact() {
        val phone = phone_editText.text.toString()
        val name = fistName_editText.text.toString()
        val lastName =
            if (lastName_editText.text.toString() != "") lastName_editText.text.toString()
            else null

        if (name != "" && phone != "") contactsViewModel.saveContact(Contact(phone, name, lastName))
    }
}