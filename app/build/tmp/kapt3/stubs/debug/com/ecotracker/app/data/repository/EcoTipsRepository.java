package com.ecotracker.app.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ9\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\u00070\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/ecotracker/app/data/repository/EcoTipsRepository;", "", "apiService", "Lcom/ecotracker/app/data/api/EcoTipsApiService;", "(Lcom/ecotracker/app/data/api/EcoTipsApiService;)V", "getDailyTip", "Lkotlinx/coroutines/flow/Flow;", "Lcom/ecotracker/app/utils/Resource;", "Lcom/ecotracker/app/data/model/EcoTip;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEcoTips", "", "category", "", "limit", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class EcoTipsRepository {
    @org.jetbrains.annotations.NotNull
    private final com.ecotracker.app.data.api.EcoTipsApiService apiService = null;
    
    public EcoTipsRepository(@org.jetbrains.annotations.NotNull
    com.ecotracker.app.data.api.EcoTipsApiService apiService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getEcoTips(@org.jetbrains.annotations.Nullable
    java.lang.String category, int limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.ecotracker.app.utils.Resource<java.util.List<com.ecotracker.app.data.model.EcoTip>>>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getDailyTip(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.ecotracker.app.utils.Resource<com.ecotracker.app.data.model.EcoTip>>> $completion) {
        return null;
    }
}