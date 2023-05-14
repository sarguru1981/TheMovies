package com.project.movieapp.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.project.movieapp.domain.entity.Movie

@Composable
fun MoviePlaySection(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String = "",
    movies: List<Movie>,
    onItemClicked: (Movie) -> Unit
) {
    val gridState = rememberLazyListState()
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            modifier = Modifier

                .padding(top = 8.dp, start = 16.dp),
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.SemiBold,
        )
        if (subtitle.isEmpty().not()) {
            Text(
                text = subtitle, modifier = Modifier

                    .padding(start = 16.dp), color = MaterialTheme.colors.onSurface.copy(0.5f),
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Left
            )
        }
        LazyRow(
            modifier = Modifier

                .padding(top = 8.dp)
                .fillMaxWidth(),
            state = gridState,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
        ) {
            itemsIndexed(movies) { _, item ->
                MovieBannerItem(
                    modifier = Modifier.clickable {
                        onItemClicked.invoke(item)
                    },
                    posterUrl = item.poster_path,
                    title = item.title,
                )
            }
        }
    }
}