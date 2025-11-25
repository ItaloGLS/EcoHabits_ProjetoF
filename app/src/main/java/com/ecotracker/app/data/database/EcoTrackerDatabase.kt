package com.ecotracker.app.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.ecotracker.app.data.model.EcoHabit

@Database(
    entities = [EcoHabit::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class EcoTrackerDatabase : RoomDatabase() {
    
    abstract fun habitDao(): HabitDao
    
    companion object {
        @Volatile
        private var INSTANCE: EcoTrackerDatabase? = null
        
        fun getDatabase(context: Context): EcoTrackerDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EcoTrackerDatabase::class.java,
                    "eco_tracker_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
