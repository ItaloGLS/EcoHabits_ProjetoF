package com.ecotracker.app.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J3\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0003\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/ecotracker/app/data/api/EcoTipsApiService;", "", "getDailyTip", "Lretrofit2/Response;", "Lcom/ecotracker/app/data/model/EcoTip;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEcoTips", "", "category", "", "limit", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface EcoTipsApiService {
    
    @retrofit2.http.GET(value = "tips")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getEcoTips(@retrofit2.http.Query(value = "category")
    @org.jetbrains.annotations.Nullable
    java.lang.String category, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.ecotracker.app.data.model.EcoTip>>> $completion);
    
    @retrofit2.http.GET(value = "tips/daily")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getDailyTip(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.ecotracker.app.data.model.EcoTip>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}