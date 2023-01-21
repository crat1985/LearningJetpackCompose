package com.learningcompose

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.learningcompose.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GoogleButton(
    basicText: String = "Sign up with Google",
    connectingText: String = "Creating account...",
    progressIndicatorColor: Color = Color.Blue,
    progressIndicatorStrokeWidth: Dp = 2.dp,
    iconPainter: Painter = painterResource(id = R.drawable.ic_google_logo),
    surfaceShape: Shape = Shapes.medium,
    border: BorderStroke = BorderStroke(width = 1.dp, color = Color.Gray),
    backgroundColor: Color = MaterialTheme.colors.surface,
    onClicked: () -> Unit = {}
) {
    var clicked by remember {
        mutableStateOf(false)
    }

    Surface(
        onClick = { clicked = !clicked },
        shape = surfaceShape,
        border = border,
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 5.dp,
                    bottom = 5.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = iconPainter,
                contentDescription = "Google Icon",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(if(clicked) connectingText else basicText)
            if(clicked) {
                Spacer(modifier = Modifier.width(10.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = progressIndicatorStrokeWidth,
                    color = progressIndicatorColor
                )
            }
            LaunchedEffect(key1 = clicked) {
                if(clicked) {
                    onClicked()
                }
            }
        }
    }
}

@Preview
@Composable
private fun GoogleButtonPreview() {
    GoogleButton()
}