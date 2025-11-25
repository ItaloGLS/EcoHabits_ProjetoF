package com.ecotracker.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "eco_habits")
data class EcoHabit(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val description: String,
    val category: HabitCategory,
    val targetValue: Double,
    val currentValue: Double = 0.0,
    val unit: String,
    val createdAt: Date = Date(),
    val isCompleted: Boolean = false
)

enum class HabitCategory {
    WATER_CONSUMPTION,
    ENERGY_SAVING,
    WASTE_REDUCTION,
    SUSTAINABLE_TRANSPORT,
    RECYCLING
}
