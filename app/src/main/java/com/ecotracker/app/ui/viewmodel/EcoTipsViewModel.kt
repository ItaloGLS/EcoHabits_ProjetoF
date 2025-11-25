package com.ecotracker.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ecotracker.app.data.model.EcoTip
import com.ecotracker.app.data.repository.EcoTipsRepository
import com.ecotracker.app.utils.Resource
import com.ecotracker.app.utils.SingleLiveEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EcoTipsViewModel(private val repository: EcoTipsRepository) : ViewModel() {
    
    private val _tips = MutableStateFlow<List<EcoTip>>(emptyList())
    val tips: StateFlow<List<EcoTip>> = _tips.asStateFlow()
    
    private val _dailyTip = MutableStateFlow<EcoTip?>(null)
    val dailyTip: StateFlow<EcoTip?> = _dailyTip.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    private val _errorMessage = SingleLiveEvent<String>()
    val errorMessage: SingleLiveEvent<String> = _errorMessage
    
    init {
        loadEcoTips()
        loadDailyTip()
    }
    
    fun loadEcoTips(category: String? = null) {
        viewModelScope.launch {
            repository.getEcoTips(category).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }
                    is Resource.Success -> {
                        _isLoading.value = false
                        _tips.value = resource.data ?: emptyList()
                    }
                    is Resource.Error -> {
                        _isLoading.value = false
                        _errorMessage.value = resource.message ?: "Erro desconhecido"
                    }
                }
            }
        }
    }
    
    private fun loadDailyTip() {
        viewModelScope.launch {
            repository.getDailyTip().collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        _dailyTip.value = resource.data
                    }
                    is Resource.Error -> {
                        _errorMessage.value = resource.message ?: "Erro ao carregar dica diária"
                    }
                    is Resource.Loading -> {
                        // Loading handled by main tips loading
                    }
                }
            }
        }
    }
    
    fun refreshTips() {
        loadEcoTips()
        loadDailyTip()
    }
    
    class Factory(private val repository: EcoTipsRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(EcoTipsViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return EcoTipsViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
