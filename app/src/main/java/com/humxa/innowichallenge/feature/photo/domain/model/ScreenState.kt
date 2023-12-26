package com.humxa.innowichallenge.feature.photo.domain.model

import androidx.compose.runtime.Immutable

@Immutable
sealed class ScreenState {
    data object LOADING : ScreenState()
    data class ERROR(val error: String? = null) : ScreenState()
    data class SUCCESS(val data: List<PhotoEntity>) : ScreenState()
}