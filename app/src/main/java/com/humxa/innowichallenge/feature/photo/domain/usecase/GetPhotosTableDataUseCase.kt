package com.humxa.innowichallenge.feature.photo.domain.usecase

import com.humxa.innowichallenge.feature.photo.domain.model.PhotoEntity
import com.humxa.innowichallenge.feature.photo.domain.model.PhotoTableData

class GetPhotosTableDataUseCase {

    suspend operator fun invoke(photos: List<PhotoEntity>): List<PhotoTableData> {
        val data = mutableListOf<PhotoTableData>()
        data.add(PhotoTableData.HEADER("Title", "Thumbnail URL"))
        var lastAlbum: Short = -1
        photos.forEach { photo ->
            if (lastAlbum != photo.albumId) {
                data.add(PhotoTableData.GROUP(photo.albumId.toString()))
                lastAlbum = photo.albumId
            }
            data.add(PhotoTableData.ROW(photo = photo))
        }
        return data.toList()
    }
}