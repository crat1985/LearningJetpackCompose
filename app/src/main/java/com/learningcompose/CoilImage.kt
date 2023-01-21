package com.learningcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter

@Composable
fun CoilImage() {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
    ) {
        /*val painter =
            rememberAsyncImagePainter("https://pbs.twimg.com/profile_images/1615036996333731864/nryEtAqY_normal.jpg")

        Image(painter, "Logo")*/
        AsyncImage(
            model = "https://pbs.twimg.com/profile_images/1615036996333731864/nryEtAqY_normal.jpg",
            contentDescription = "Logo de ma P.P. Twitter",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape).width(200.dp).height(200.dp),
            placeholder = painterResource(R.drawable.placeholder),

        )
    }
}