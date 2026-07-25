package dev.awd.tab5a.domain.model

data class Meal(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val chef: String,
    val rating: Double,
    val ratingCount: Int = 0,
    val category: String,
    val ingredients: Map<Ingredient, String> = emptyMap(),
)