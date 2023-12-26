package com.humxa.innowichallenge.feature.photo.domain.repository

import com.humxa.innowichallenge.feature.photo.domain.model.PhotoEntity

interface PhotoRepository {
    suspend fun downloadPhotos(): List<PhotoEntity>
}