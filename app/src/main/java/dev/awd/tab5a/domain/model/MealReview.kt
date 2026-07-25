package dev.awd.tab5a.domain.model

data class MealReview(
    val id: String,
    val author: String,
    val rating: Double,
    val comment: String,
)