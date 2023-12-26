package com.humxa.innowichallenge.feature.photo.domain.usecase

data class PhotosUseCases(
    val downloadPhotos: DownloadPhotosUseCase,
    val getTableData: GetPhotosTableDataUseCase
)