package dev.awd.tab5a.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    object Greeting : Screen()

    @Serializable
    object Login : Screen()

    @Serializable
    object Register : Screen()

    @Serializable
    object Home : Screen()

    @Serializable
    object Search : Screen()

    @Serializable
    object Favorites : Screen()

    @Serializable
    data class MealDetails(val mealId: String) : Screen()
}
