package com.humxa.innowichallenge.feature.photo.data.datasource.remote

import com.humxa.innowichallenge.feature.photo.domain.model.PhotoEntity
import retrofit2.http.GET

interface ApiService {

    @GET("photos")
    suspend fun getPhotos(): List<PhotoEntity>
}