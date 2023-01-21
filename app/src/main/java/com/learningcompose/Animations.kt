package com.learningcompose

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun Animations() {
    var sizeState by remember {
        mutableStateOf(100.dp)
    }

    val sizeStateAnimation by animateDpAsState(
        targetValue = sizeState
    )

    LaunchedEffect(true) {
        sizeState = 200.dp
    }

    Box(modifier = Modifier
        .size(sizeStateAnimation)
        .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    sizeState += 25.dp
                }
            ) {
                Text("Increase size")
            }

            Button(
                onClick = {
                    sizeState = 200.dp
                }
            ) {
                Text("Reset size")
            }
        }
    }
}