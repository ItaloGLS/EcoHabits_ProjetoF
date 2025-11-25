package com.ecotracker.app.data.repository

import com.ecotracker.app.data.api.EcoTipsApiService
import com.ecotracker.app.data.model.EcoTip
import com.ecotracker.app.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EcoTipsRepository(private val apiService: EcoTipsApiService) {
    
    suspend fun getEcoTips(category: String? = null, limit: Int = 10): Flow<Resource<List<EcoTip>>> = flow {
        try {
            emit(Resource.Loading())
            val response = apiService.getEcoTips(category, limit)
            if (response.isSuccessful) {
                response.body()?.let { tips ->
                    emit(Resource.Success(tips))
                } ?: emit(Resource.Error("Dados não encontrados"))
            } else {
                emit(Resource.Error("Erro na API: ${response.code()}"))
            }
        } catch (e: Exception) {
            // Fallback para dados mock quando API não estiver disponível
            val mockTips = MockDataRepository.getMockEcoTips()
            emit(Resource.Success(mockTips))
        }
    }
    
    suspend fun getDailyTip(): Flow<Resource<EcoTip>> = flow {
        try {
            emit(Resource.Loading())
            val response = apiService.getDailyTip()
            if (response.isSuccessful) {
                response.body()?.let { tip ->
                    emit(Resource.Success(tip))
                } ?: emit(Resource.Error("Dica não encontrada"))
            } else {
                emit(Resource.Error("Erro na API: ${response.code()}"))
            }
        } catch (e: Exception) {
            // Fallback para dados mock quando API não estiver disponível
            val mockTip = MockDataRepository.getDailyTip()
            emit(Resource.Success(mockTip))
        }
    }
}
