package com.example.androiddraft.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Int,
    val name: String,
    val lastName: String,
    val age: Int
) : Parcelable