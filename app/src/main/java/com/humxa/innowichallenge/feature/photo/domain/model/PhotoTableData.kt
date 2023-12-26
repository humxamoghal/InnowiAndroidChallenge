package com.humxa.innowichallenge.feature.photo.domain.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import kotlin.random.Random
@Stable
@Immutable
sealed class PhotoTableData(val id: Int = Random.nextInt()) {
    data class HEADER(val first: String, val second: String) : PhotoTableData()
    data class GROUP(val groupName: String) : PhotoTableData()
    data class ROW(val photo: PhotoEntity) : PhotoTableData(photo.id)
}