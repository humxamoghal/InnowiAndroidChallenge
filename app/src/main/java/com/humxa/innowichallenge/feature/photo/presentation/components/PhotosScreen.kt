package com.humxa.innowichallenge.feature.photo.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.humxa.innowichallenge.R
import com.humxa.innowichallenge.feature.photo.domain.model.PhotoTableData
import com.humxa.innowichallenge.feature.photo.domain.model.ScreenState
import com.humxa.innowichallenge.feature.photo.presentation.viewmodel.PhotosViewModel

@Composable
fun PhotoList(photos: SnapshotStateList<PhotoTableData>) {
    LazyColumn(
        modifier = Modifier
            .padding(12.dp)
            .border(BorderStroke(0.5.dp, Color.Black))
    ) {
        itemsIndexed(
            items = photos,
            key = { _, item -> item.id }
        ) { index, data ->

            when (data) {
                is PhotoTableData.HEADER -> {
                    HeaderCell(data.first, data.second)
                }

                is PhotoTableData.GROUP -> {
                    GroupCell(title = data.groupName)
                }

                is PhotoTableData.ROW -> {
                    PhotoTableCell(
                        photo = data.photo,
                        isLast = index == photos.lastIndex
                    )
                }
            }
        }
    }
}

@Composable
fun PhotoScreen() {
    val viewModel: PhotosViewModel = hiltViewModel()
    LaunchedEffect(true) {
        viewModel.downloadPhotos()
    }
    val state = viewModel.screenState.collectAsStateWithLifecycle()
    when (state.value) {
        is ScreenState.SUCCESS -> PhotoList(photos = viewModel.photos)
        is ScreenState.ERROR -> EmptyView(
            message = (state.value as ScreenState.ERROR).error
                ?: stringResource(id = R.string.msg_network_error),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )

        ScreenState.LOADING -> LoadingScreen()
    }
}