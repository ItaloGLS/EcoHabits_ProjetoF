package com.ecotracker.app.data.repository

import com.ecotracker.app.data.database.HabitDao
import com.ecotracker.app.data.model.EcoHabit
import kotlinx.coroutines.flow.Flow

class HabitRepository(private val habitDao: HabitDao) {
    
    fun getAllHabits(): Flow<List<EcoHabit>> = habitDao.getAllHabits()
    
    fun getActiveHabits(): Flow<List<EcoHabit>> = habitDao.getActiveHabits()
    
    fun getCompletedHabits(): Flow<List<EcoHabit>> = habitDao.getCompletedHabits()
    
    suspend fun getHabitById(id: Long): EcoHabit? = habitDao.getHabitById(id)
    
    suspend fun insertHabit(habit: EcoHabit): Long = habitDao.insertHabit(habit)
    
    suspend fun updateHabit(habit: EcoHabit) = habitDao.updateHabit(habit)
    
    suspend fun deleteHabit(habit: EcoHabit) = habitDao.deleteHabit(habit)
}
