package com.example.self_care.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Artikel(val titleImage: Int, val heading:String, val content:String) : Parcelable
