package com.example.photosample.data.service

import com.example.photosample.data.BuildConfig
import com.example.photosample.data.products.entity.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("v1/images/search")
    suspend fun fetchPhoto(
        @Query("limit") limit: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): List<PhotoResponse>
}