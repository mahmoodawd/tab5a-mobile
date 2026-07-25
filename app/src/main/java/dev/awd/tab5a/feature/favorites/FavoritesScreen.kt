package dev.awd.tab5a.feature.favorites

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Favorite
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.error
import coil3.request.placeholder
import dev.awd.tab5a.R
import dev.awd.tab5a.core.theme.Tab5aTheme
import dev.awd.tab5a.core.ui.sampleMeals
import dev.awd.tab5a.domain.model.Meal

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.favorites),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp, bottom = 8.dp)
        )
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(sampleMeals) {
                FavoriteMealItem(meal = it)
            }
        }
    }

}


@Composable
private fun FavoriteMealItem(
    modifier: Modifier = Modifier,
    meal: Meal,
) {
    val context = LocalContext.current
    ElevatedCard(
        modifier = modifier
            .padding(8.dp)

    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box {
                Icon(
                    imageVector = Icons.TwoTone.Favorite, contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.TopEnd)
                        .background(
                            MaterialTheme.colorScheme.background,
                            RoundedCornerShape(12.dp)
                        )
                        .padding(8.dp)
                )
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .data(meal.imageUrl)
                        .error(R.drawable.ic_launcher_foreground)
                        .build(),
                    contentDescription = meal.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .aspectRatio(16 / 9f)
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clip(RoundedCornerShape(24.dp))
                )
            }
        }
        Spacer(Modifier.weight(1f))
        Text(
            text = meal.title,
            modifier = Modifier
                .widthIn(100.dp)
                .padding(horizontal = 16.dp),
            style = MaterialTheme.typography.titleLarge,
            overflow = TextOverflow.Clip,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Text(
            text = meal.chef,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FavoritesPreview() {
    Tab5aTheme {
        FavoritesScreen()
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun FavoritesPreviewNight() {
    Tab5aTheme {
        FavoritesScreen()
    }
}