package dev.awd.tab5a.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.awd.tab5a.data.local.dao.MealDao
import dev.awd.tab5a.data.local.entity.MealEntity

@Database(entities = [MealEntity::class], version = 1, exportSchema = false)
abstract class Tab5aDatabase : RoomDatabase() {
    abstract fun mealDao(): MealDao
}
