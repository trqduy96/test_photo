package com.example.photosample.presentation.product

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoList(
    val id: Int,
    val url: String,
): Parcelable
