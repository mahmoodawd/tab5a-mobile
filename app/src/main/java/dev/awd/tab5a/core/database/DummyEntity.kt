package dev.awd.tab5a.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dummy")
data class DummyEntity(
    @PrimaryKey val id: Int = 1,
)
