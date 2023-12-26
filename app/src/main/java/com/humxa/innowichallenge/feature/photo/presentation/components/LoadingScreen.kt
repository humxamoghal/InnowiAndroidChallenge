package com.humxa.innowichallenge.feature.photo.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun LoadingScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    Box(modifier = modifier.pointerInput(Unit) { }) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}