package com.example.androiddraft

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androiddraft.models.Contact

@Database(entities = [Contact::class], version = 1)
abstract class ContactsDatabase : RoomDatabase(){
    abstract fun contactDato() : ContactDao

    companion object{
        private const val DATABASE_NAME = "score_database.db"

        @Volatile
        private var INSTANCE: ContactsDatabase? = null

        fun getInstance(context: Context): ContactsDatabase?{
            INSTANCE ?: synchronized(this){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ContactsDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }
}