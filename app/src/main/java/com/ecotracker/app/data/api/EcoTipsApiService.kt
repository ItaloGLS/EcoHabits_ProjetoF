package com.ecotracker.app.data.api

import com.ecotracker.app.data.model.EcoTip
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EcoTipsApiService {
    
    @GET("tips")
    suspend fun getEcoTips(
        @Query("category") category: String? = null,
        @Query("limit") limit: Int = 10
    ): Response<List<EcoTip>>
    
    @GET("tips/daily")
    suspend fun getDailyTip(): Response<EcoTip>
}
