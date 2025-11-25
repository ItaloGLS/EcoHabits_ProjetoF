package com.ecotracker.app.data.database

import androidx.room.TypeConverter
import com.ecotracker.app.data.model.HabitCategory
import java.util.Date

class Converters {
    
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }
    
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
    
    @TypeConverter
    fun fromHabitCategory(category: HabitCategory): String {
        return category.name
    }
    
    @TypeConverter
    fun toHabitCategory(category: String): HabitCategory {
        return HabitCategory.valueOf(category)
    }
}
