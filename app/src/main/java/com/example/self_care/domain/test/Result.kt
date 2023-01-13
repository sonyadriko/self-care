package com.example.self_care.domain.test

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result (val totalScore: Int, val message: String): Parcelable