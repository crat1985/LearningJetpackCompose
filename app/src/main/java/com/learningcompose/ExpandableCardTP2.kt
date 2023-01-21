package com.learningcompose

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import kotlin.math.exp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCardTP2(
    title: String = "Titre de l'actu",
    titleWeight: FontWeight = FontWeight.Bold,
    titleSize: TextUnit = MaterialTheme.typography.h6.fontSize,
    titleColor: Color = MaterialTheme.colors.onBackground,
    description: String = "Une description random",
    descriptionStyle: FontStyle = FontStyle.Italic,
    descriptionSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize
) {
    var expandedState by remember {
        mutableStateOf(false)
    }

    val rotationAnimation by animateFloatAsState(
        targetValue = if(expandedState) 180f else 0f,
    )

    Card(
        modifier = Modifier.fillMaxWidth().animateContentSize(
            animationSpec = tween(
                durationMillis = 500,
                easing = LinearOutSlowInEasing
            )
        ),
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    modifier = Modifier.weight(6f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = titleSize,
                    fontWeight = titleWeight,
                    color = titleColor
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
            if(expandedState) Text(
                text = description,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
                fontStyle = descriptionStyle,
                fontSize = descriptionSize
            )
        }
    }
}