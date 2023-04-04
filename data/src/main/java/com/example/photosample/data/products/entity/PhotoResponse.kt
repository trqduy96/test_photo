package com.example.photosample.data.products.entity

import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("id") val id: String,
    @SerializedName("url") val url: String,
)


