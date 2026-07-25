package dev.awd.tab5a.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals")
data class MealEntity(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val chef: String,
    val rating: Double,
    val ratingCount: Int,
    val category: String,
    val ingredientsJson: String, // Serialized Map<Ingredient, String>
)
