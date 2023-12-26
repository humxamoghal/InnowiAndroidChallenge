package com.humxa.innowichallenge.feature.photo

import com.humxa.innowichallenge.feature.photo.domain.model.PhotoEntity
import com.humxa.innowichallenge.feature.photo.domain.model.PhotoTableData
import com.humxa.innowichallenge.feature.photo.domain.model.ScreenState

class FakeDataProvider {
    val photos = listOf(
        PhotoEntity(1, 1, "Title 1", "URL 1", "URL 1"),
        PhotoEntity(2, 2, "Title 2", "URL 2", "URL 2"),
        PhotoEntity(3, 2, "Title 3", "URL 3", "URL 3")
    )
    val tableData = listOf(
        PhotoTableData.HEADER("Title", "Thumbnail URL"),
        PhotoTableData.GROUP("1"),
        PhotoTableData.ROW(PhotoEntity(1, 1, "Title 1", "URL 1", "URL 1")),
        PhotoTableData.GROUP("2"),
        PhotoTableData.ROW(PhotoEntity(1, 2, "Title 2", "URL 2", "URL 2")),
        PhotoTableData.ROW(PhotoEntity(3, 2, "Title 3", "URL 3", "URL 3"))
    )
    val mockedStateSuccess = ScreenState.SUCCESS(data = photos)
}