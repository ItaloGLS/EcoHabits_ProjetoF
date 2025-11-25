package com.ecotracker.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ecotracker.app.data.model.EcoHabit
import com.ecotracker.app.data.repository.HabitRepository
import com.ecotracker.app.utils.SingleLiveEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HabitViewModel(private val repository: HabitRepository) : ViewModel() {
    
    private val _habits = MutableStateFlow<List<EcoHabit>>(emptyList())
    val habits: StateFlow<List<EcoHabit>> = _habits.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    private val _errorMessage = SingleLiveEvent<String>()
    val errorMessage: SingleLiveEvent<String> = _errorMessage
    
    private val _successMessage = SingleLiveEvent<String>()
    val successMessage: SingleLiveEvent<String> = _successMessage
    
    private val _navigateToDetail = SingleLiveEvent<Long>()
    val navigateToDetail: SingleLiveEvent<Long> = _navigateToDetail
    
    init {
        loadHabits()
    }
    
    private fun loadHabits() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                repository.getAllHabits().collect { habitList ->
                    _habits.value = habitList
                    _isLoading.value = false
                }
            } catch (e: Exception) {
                _errorMessage.value = "Erro ao carregar hábitos: ${e.localizedMessage}"
                _isLoading.value = false
            }
        }
    }
    
    fun addHabit(habit: EcoHabit) {
        viewModelScope.launch {
            try {
                repository.insertHabit(habit)
                _successMessage.value = "Hábito adicionado com sucesso!"
            } catch (e: Exception) {
                _errorMessage.value = "Erro ao adicionar hábito: ${e.localizedMessage}"
            }
        }
    }
    
    fun updateHabit(habit: EcoHabit) {
        viewModelScope.launch {
            try {
                repository.updateHabit(habit)
                _successMessage.value = "Hábito atualizado com sucesso!"
            } catch (e: Exception) {
                _errorMessage.value = "Erro ao atualizar hábito: ${e.localizedMessage}"
            }
        }
    }
    
    fun deleteHabit(habit: EcoHabit) {
        viewModelScope.launch {
            try {
                repository.deleteHabit(habit)
                _successMessage.value = "Hábito removido com sucesso!"
            } catch (e: Exception) {
                _errorMessage.value = "Erro ao remover hábito: ${e.localizedMessage}"
            }
        }
    }
    
    fun onHabitClicked(habitId: Long) {
        _navigateToDetail.value = habitId
    }
    
    suspend fun getHabitById(id: Long): EcoHabit? {
        return repository.getHabitById(id)
    }
    
    class Factory(private val repository: HabitRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HabitViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return HabitViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
