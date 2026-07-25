package dev.awd.tab5a.ui.common

import RatingBar
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import dev.awd.tab5a.domain.model.Meal
import dev.awd.tab5a.domain.model.MealReview
import dev.awd.tab5a.ui.common.components.Tab5aButton
import dev.awd.tab5a.ui.common.components.Tab5aIconButton
import dev.awd.tab5a.ui.theme.Tab5aTheme

@Composable
fun MealDetailsScreen(
    modifier: Modifier = Modifier,
    meal: Meal,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        VideoPlayerView(
            thumbnailUrl = meal.imageUrl,
            onClosesClick = {},
            onFavoriteClick = {}
        )
        DetailsSheet(meal = meal, modifier = Modifier.offset(y = (-16).dp))
    }
}

@Composable
fun VideoPlayerView(
    modifier: Modifier = Modifier,
    thumbnailUrl: String,
    onFavoriteClick: () -> Unit,
    onClosesClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = thumbnailUrl,
            contentDescription = thumbnailUrl,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        )
        Tab5aIconButton(
            modifier = Modifier
                .align(Alignment.TopStart),
            icon = Icons.Default.Close,
            contentDescription = "Close",
            contentColor = MaterialTheme.colorScheme.onSurface,
            containerColor = MaterialTheme.colorScheme.onPrimary,
            onClick = onClosesClick,
        )
        Tab5aIconButton(
            modifier = Modifier
                .align(Alignment.TopEnd),
            icon = Icons.Default.FavoriteBorder,
            contentDescription = "Add to favorites",
            contentColor = MaterialTheme.colorScheme.onSurface,
            containerColor = MaterialTheme.colorScheme.onPrimary,
            onClick = onFavoriteClick,
        )
        OutlinedIconButton(
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = MaterialTheme.colorScheme.onPrimary,
            ),
            border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.onPrimary),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .scale(2f)
                .widthIn(58.dp)
                .align(Alignment.Center), onClick = {}) {
            Icon(
                imageVector = Icons.Outlined.PlayArrow,
                contentDescription = "Play"
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailsSheet(
    modifier: Modifier = Modifier,
    meal: Meal,
) {
    Surface(
        modifier = modifier
            .fillMaxHeight(),
        shape = RoundedCornerShape(
            topStart = 24.dp,
            topEnd = 24.dp
        ),
        tonalElevation = 16.dp,
        shadowElevation = 16.dp,
    ) {
        Column(
            modifier = modifier
                .fillMaxHeight()
                .padding(16.dp),

            ) {
            BottomSheetDefaults.DragHandle(modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(
                text = meal.title,
                modifier = Modifier
                    .widthIn(100.dp),
                style = MaterialTheme.typography.titleLarge,
                overflow = TextOverflow.Clip,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Text(
                text = meal.description,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(bottom = 8.dp),
            )
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                item {
                    FactsItem(icon = Icons.Default.Star, value = meal.rating.toString())
                }
                item {
                    FactsItem(icon = Icons.Default.Category, value = meal.category)
                }
                item {
                    FactsItem(icon = Icons.Default.Numbers, value = meal.ratingCount.toString())
                }
                item {
                    FactsItem(icon = Icons.Default.MonitorWeight, value = meal.category)
                }
            }

            var tabType by remember { mutableStateOf<MealTabType>(MealTabType.Ingredients) }
            TabRow(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(16.dp)),
                selectedTabIndex = when (tabType) { // Determine index based on type
                    MealTabType.Ingredients -> 0
                    MealTabType.Comments -> 1
                },
                containerColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.5f),
                contentColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.5f),
                divider = {},
                indicator = {}
            ) {
                MealTab(
                    title = "Ingredients",
                    selected = tabType == MealTabType.Ingredients,
                    onTabSelected = { tabType = MealTabType.Ingredients })
                MealTab(
                    title = "Comments",
                    selected = tabType == MealTabType.Comments,
                    onTabSelected = { tabType = MealTabType.Comments })

            }
            TabContent(
                modifier = Modifier.weight(1f), // Allow content to take remaining space
                selectedTabType = tabType,
                meal = meal,
                onAddToFavoritesClick = {
                    // Handle Add to Favorites click
                },
                onAddRatingClick = {
                    // Handle Add Rating click
                })
        }

    }
}


@Composable
fun TabContent(
    modifier: Modifier = Modifier,
    selectedTabType: MealTabType,
    meal: Meal,
    onAddToFavoritesClick: () -> Unit,
    onAddRatingClick: () -> Unit,
) {
    when (selectedTabType) {
        MealTabType.Ingredients -> {
            ScrollableContentWithButton(
                modifier = modifier,
                items = meal.ingredients.keys.toList(),
                itemContent = { ingredient -> // ingredient is of type Ingredient (your data class)
                    IngredientItem(
                        ingredient = ingredient.title, measure = meal.ingredients[ingredient] ?: "",
                        imageUrl = ingredient.imageUrl
                    )
                },
                buttonText = "Add to Favorites",
                onButtonClick = onAddToFavoritesClick
            )
        }

        MealTabType.Comments -> {
            ScrollableContentWithButton(
                modifier = modifier,
                items = sampleMealReviews, // Assuming sampleMealReviews is List<MealReview>
                itemContent = { review -> // review is of type MealReview
                    ReviewItem(review = review)
                },
                buttonText = "Add Rating",
                onButtonClick = onAddRatingClick
            )
        }
    }
}

@Composable
fun <T> ScrollableContentWithButton(
    modifier: Modifier = Modifier,
    items: List<T>,
    itemContent: @Composable (T) -> Unit,
    buttonText: String,
    onButtonClick: () -> Unit,
    lazyListModifier: Modifier = Modifier, // For specific LazyColumn modifications
    buttonModifier: Modifier = Modifier,    // For specific Button modifications
) {
    Column(modifier = modifier.fillMaxSize()) { // Ensure Column takes up available space
        LazyColumn(
            modifier = Modifier
                .weight(1f) // Takes up available vertical space
                .then(lazyListModifier) // Apply additional modifiers if any
        ) {
            items(
                items = items,
                key = { item -> item.hashCode() } // Provide a stable key if items can change
            ) { item ->
                itemContent(item)
            }
        }
        Tab5aButton(
            onClick = onButtonClick,
            label = buttonText,
            modifier = buttonModifier
        )

    }
}

@Composable
fun MealTab(
    modifier: Modifier = Modifier,
    title: String,
    selected: Boolean,
    onTabSelected: () -> Unit,
) {
    val backgroundColor = if (selected) MaterialTheme.colorScheme.secondary
    else Color.Transparent
    Tab(
        modifier = modifier.padding(vertical = 2.dp),
        selected = selected,
        selectedContentColor = MaterialTheme.colorScheme.onSecondary,
        unselectedContentColor = MaterialTheme.colorScheme.onBackground,
        onClick = onTabSelected
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Visible,
            textAlign = TextAlign.Center,
            fontWeight = if (selected) FontWeight.ExtraBold else FontWeight.Bold,
            softWrap = false,
            maxLines = 1,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp))
                .background(backgroundColor)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Composable
private fun FactsItem(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    value: String,
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon, contentDescription = icon.name,
            modifier = Modifier
                .padding(8.dp)
                .background(
                    MaterialTheme.colorScheme.tertiary.copy(alpha = 0.5f),
                    RoundedCornerShape(12.dp)
                )
                .padding(8.dp)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp),
        )
    }
}


@Composable
fun IngredientItem(
    modifier: Modifier = Modifier,
    ingredient: String,
    measure: String,
    imageUrl: String,
) {
    val context = LocalContext.current
    ElevatedCard(
        modifier = modifier
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest
                    .Builder(context)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .data(imageUrl).build(),
                contentDescription = ingredient,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(24.dp))
            )
            Text(
                text = ingredient,
                modifier = Modifier
                    .widthIn(100.dp)
                    .padding(horizontal = 16.dp),
                style = MaterialTheme.typography.titleLarge,
                overflow = TextOverflow.Clip,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = measure,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(16.dp),
            )
        }
    }

}

@Composable
fun ReviewItem(
    modifier: Modifier = Modifier,
    review: MealReview,
) {
    Card(
        elevation = CardDefaults.cardElevation(16.dp),
        modifier = modifier
            .padding(12.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = "https://unsplash.com/photos/a-cartoon-character-with-a-weird-haircut-G2Qjx1y9aAM",
                contentDescription = review.author,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .padding(16.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = modifier
            ) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = review.author,
                        fontWeight = FontWeight.ExtraBold,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    RatingBar(
                        rating = review.rating,
                        starsColor = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.padding(12.dp),
                    )
                }
                Text(
                    text = review.comment,
                    minLines = 2,
                    overflow = TextOverflow.Clip,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .widthIn(50.dp),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MealDetailsPreview() {
    Tab5aTheme {
        MealDetailsScreen(meal = sampleMeals.random())
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun MealDetailsPreviewNight() {
    Tab5aTheme {
        MealDetailsScreen(meal = sampleMeals.random())
    }
}

sealed interface MealTabType {
    object Ingredients : MealTabType
    object Comments : MealTabType
}