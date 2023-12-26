package com.humxa.innowichallenge.feature.photo.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.humxa.innowichallenge.feature.photo.domain.model.PhotoTableData
import com.humxa.innowichallenge.feature.photo.domain.model.ScreenState
import com.humxa.innowichallenge.feature.photo.domain.usecase.PhotosUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val useCases: PhotosUseCases
) : ViewModel() {

    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.LOADING)
    val screenState: StateFlow<ScreenState>
        get() = _screenState

    val photos = mutableStateListOf<PhotoTableData>()

    fun downloadPhotos() {
        viewModelScope.launch {
            useCases.downloadPhotos.invoke().collect { state ->
                if (state is ScreenState.SUCCESS) {
                    performFiltering(state)
                } else {
                    _screenState.value = state
                }
            }
        }
    }

    private fun performFiltering(state: ScreenState.SUCCESS) {
        viewModelScope.launch {
            val tableData = useCases.getTableData.invoke(photos = state.data)
            _screenState.value = state
            photos.addAll(tableData)
        }
    }
}