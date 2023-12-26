package com.humxa.innowichallenge.feature.photo.data.repository

import com.humxa.innowichallenge.feature.photo.data.datasource.local.PhotoDao
import com.humxa.innowichallenge.feature.photo.data.datasource.remote.ApiService
import com.humxa.innowichallenge.feature.photo.domain.model.PhotoEntity
import com.humxa.innowichallenge.feature.photo.domain.repository.PhotoRepository

class PhotoRepositoryImpl(
    private val photoDao: PhotoDao,
    private val apiService: ApiService
) : PhotoRepository {

    override suspend fun downloadPhotos(): List<PhotoEntity> {
        val localData = photoDao.getPhotos()
        return if (localData.isEmpty().not()) {
            localData
        } else {
            val response = apiService.getPhotos()
            val size = photoDao.insertAllPhotos(response)
            print(size.size == response.size)
            response
        }
    }

}