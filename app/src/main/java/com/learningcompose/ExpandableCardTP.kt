package com.learningcompose

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCardTP(
    title: String = "Titre",
    description: String = "eifhzeiuh uie giregfieuzg uirgzi gzyeg riuzeiu rzuieyu ryeiur iyz yrgezy yzeuy rzeyuyrhyuz uy"
) {
    var expandedState by remember {
        mutableStateOf(false)
    }

    val rotationAnimation by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier.fillMaxWidth().background(MaterialTheme.colors.background).animateContentSize(
            animationSpec = tween(
                durationMillis = 500,
                //easing = LinearOutSlowInEasing
            )
        ),
        onClick = {
            expandedState = !expandedState
        },
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    title,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        color = MaterialTheme.colors.onBackground
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(6f)
                )
                IconButton(
                    onClick = {
                        expandedState = !expandedState
                    },
                    modifier = Modifier.alpha(ContentAlpha.medium).weight(1f).rotate(rotationAnimation)
                ) {
                    Icon(Icons.Default.ArrowDropDown, "")
                }
            }
            if (expandedState) Text(description, maxLines = 4)
        }
    }
}

@Composable
@Preview
fun ExpandableCardTPDefaultPreview() {
    ExpandableCardTP()
}