package com.humxa.innowichallenge.feature.photo.domain.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
@Stable
@Immutable
data class PhotoEntity(
    @PrimaryKey val id: Int,
    val albumId: Short, // It can store around +- 32000 so I tried to saved memory usage here
    val title: String,
    val url: String,
    val thumbnailUrl: String
)
