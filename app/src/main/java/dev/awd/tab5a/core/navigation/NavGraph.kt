package dev.awd.tab5a.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import dev.awd.tab5a.core.ui.sampleMeals
import dev.awd.tab5a.feature.auth.GreetingScreen
import dev.awd.tab5a.feature.auth.LoginScreen
import dev.awd.tab5a.feature.auth.RegisterScreen
import dev.awd.tab5a.feature.favorites.FavoritesScreen
import dev.awd.tab5a.feature.home.HomeScreen
import dev.awd.tab5a.feature.meal.MealDetailsScreen
import dev.awd.tab5a.feature.search.SearchScreen

@Composable
fun Tab5aNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home,
        modifier = modifier
    ) {
        composable<Screen.Greeting> {
            GreetingScreen(
                onLoginClick = { navController.navigate(Screen.Login) },
                onCreateAccountClick = { navController.navigate(Screen.Register) },
                onLaterClick = { navController.navigate(Screen.Home) }
            )
        }
        composable<Screen.Login> {
            LoginScreen()
        }
        composable<Screen.Register> {
            RegisterScreen()
        }
        composable<Screen.Home> {
            HomeScreen()
        }
        composable<Screen.Search> {
            SearchScreen()
        }
        composable<Screen.Favorites> {
            FavoritesScreen()
        }
        composable<Screen.MealDetails> { backStackEntry ->
            val details = backStackEntry.toRoute<Screen.MealDetails>()
            // In a real app, we'd fetch by ID. Using sample for now.
            val meal = sampleMeals.find { it.id == details.mealId } ?: sampleMeals.first()
            MealDetailsScreen(meal = meal)
        }
    }
}
