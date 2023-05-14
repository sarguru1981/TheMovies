package com.project.movieapp.android.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale

@Composable
fun MovieBannerItem(
    modifier: Modifier = Modifier,
    posterUrl: String,
    title: String
) {
    Column(
        modifier = modifier
            .width(130.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(posterUrl)
                .scale(Scale.FIT)
                .build(),
            modifier = Modifier
                .width(130.dp)
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = title,
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.caption,
            fontWeight = FontWeight.SemiBold,
            maxLines = 2
        )
    }
}