package com.humxa.innowichallenge.feature.photo.domain.usecase

import com.humxa.innowichallenge.feature.photo.domain.model.ScreenState
import com.humxa.innowichallenge.feature.photo.domain.repository.PhotoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class DownloadPhotosUseCase(
    private val photosRepository: PhotoRepository
) {

    suspend operator fun invoke() = flow {
        try {
            emit(ScreenState.LOADING)
            emit(ScreenState.SUCCESS(photosRepository.downloadPhotos()))
        } catch (e: Exception) {
            emit(ScreenState.ERROR(e.localizedMessage))
        }
    }.flowOn(Dispatchers.IO)
}