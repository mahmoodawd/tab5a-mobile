package dev.awd.tab5a.feature.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import dev.awd.tab5a.core.theme.Tab5aTheme
import dev.awd.tab5a.core.ui.components.RatingBar
import dev.awd.tab5a.core.ui.getGreetingInfo
import dev.awd.tab5a.core.ui.sampleCategories
import dev.awd.tab5a.core.ui.sampleMeals
import dev.awd.tab5a.domain.model.Meal
import dev.awd.tab5a.R as Resources

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        GreetingWidget(username = "Mahmoud", modifier = Modifier.fillMaxWidth())
        Text(
            stringResource(Resources.string.featured),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        LazyRow {
            items(sampleMeals) { meal ->
                FeaturedMealItem(
                    meal = meal,
                    modifier = Modifier.fillParentMaxWidth(0.8f)
                )
            }
        }
        Text(
            stringResource(Resources.string.category),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )

        var selectedTabIndex by remember { mutableIntStateOf(0) }
        var selectedCategory by remember { mutableStateOf(sampleCategories[selectedTabIndex]) }

        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            edgePadding = 4.dp,
            containerColor = Color.Transparent,
            divider = {},
            indicator = {}) {
            sampleCategories.forEachIndexed { index, category ->
                Tab(
                    selected = selectedTabIndex == index,
                    selectedContentColor = MaterialTheme.colorScheme.onSurface,
                    unselectedContentColor = MaterialTheme.colorScheme.onBackground,
                    onClick = {
                        selectedTabIndex = index
                        selectedCategory = category
                    }) {
                    Text(
                        text = category,
                        style = MaterialTheme.typography.bodyLarge,
                        overflow = TextOverflow.Visible,
                        softWrap = false,
                        maxLines = 1,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(
                                if (selectedTabIndex == index) MaterialTheme.colorScheme.primary
                                else MaterialTheme.colorScheme.background
                            )
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                }
            }
        }
        Text(
            stringResource(Resources.string.popular_meals),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        LazyRow {
            items(sampleMeals.filter { it.category == selectedCategory }) { meal ->
                PopularMealItem(meal = meal)
            }
        }
    }
}


@Composable
fun GreetingWidget(
    username: String,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val greetingInfo = remember { getGreetingInfo(context) }
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = greetingInfo.icon,
                contentDescription = greetingInfo.greetingText,
                tint = MaterialTheme.colorScheme.onBackground,
                modifier =
                    Modifier.padding(end = 8.dp)
            )
            Text(
                text = greetingInfo.greetingText,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
        Text(
            text = username,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge,
            modifier =
                Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun FeaturedMealItem(
    modifier: Modifier = Modifier,
    meal: Meal,
) {
    Card(
        modifier = modifier
            .widthIn(350.dp)
            .height(200.dp)
            .padding(8.dp)

    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                model = meal.imageUrl,
                contentDescription = meal.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f))
                    .padding(8.dp)
            ) {
                Spacer(Modifier.weight(1f))
                Text(
                    text = meal.title,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.titleLarge,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = meal.chef,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White
                    )
                    Spacer(Modifier.weight(1f))
                    RatingBar(
                        rating = meal.rating,
                        starsColor = Color.White,
                        modifier = Modifier,
                    )
                }
            }
        }
    }
}


@Composable
private fun PopularMealItem(
    modifier: Modifier = Modifier,
    meal: Meal,
) {
    ElevatedCard(
        modifier = modifier
            .padding(8.dp)

    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = meal.imageUrl,
                contentDescription = meal.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(24.dp))
            )
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
private fun HomeScreenPreview() {
    Tab5aTheme {
        HomeScreen()
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun HomeScreenPreviewNight() {
    Tab5aTheme {
        HomeScreen()
    }
}

@Preview(locale = "ar-rEG", showBackground = true)
@Composable
private fun HomeScreenPreviewArabic() {
    Tab5aTheme {
        HomeScreen()
    }
}
