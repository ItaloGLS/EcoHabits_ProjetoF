package com.ecotracker.app.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ecotracker.app.data.model.EcoHabit
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    
    @Query("SELECT * FROM eco_habits ORDER BY createdAt DESC")
    fun getAllHabits(): Flow<List<EcoHabit>>
    
    @Query("SELECT * FROM eco_habits WHERE id = :id")
    suspend fun getHabitById(id: Long): EcoHabit?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHabit(habit: EcoHabit): Long
    
    @Update
    suspend fun updateHabit(habit: EcoHabit)
    
    @Delete
    suspend fun deleteHabit(habit: EcoHabit)
    
    @Query("SELECT * FROM eco_habits WHERE isCompleted = 0")
    fun getActiveHabits(): Flow<List<EcoHabit>>
    
    @Query("SELECT * FROM eco_habits WHERE isCompleted = 1")
    fun getCompletedHabits(): Flow<List<EcoHabit>>
}
