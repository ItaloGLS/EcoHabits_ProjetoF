package com.ecotracker.app.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bJ\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/ecotracker/app/data/repository/HabitRepository;", "", "habitDao", "Lcom/ecotracker/app/data/database/HabitDao;", "(Lcom/ecotracker/app/data/database/HabitDao;)V", "deleteHabit", "", "habit", "Lcom/ecotracker/app/data/model/EcoHabit;", "(Lcom/ecotracker/app/data/model/EcoHabit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveHabits", "Lkotlinx/coroutines/flow/Flow;", "", "getAllHabits", "getCompletedHabits", "getHabitById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertHabit", "updateHabit", "app_debug"})
public final class HabitRepository {
    @org.jetbrains.annotations.NotNull
    private final com.ecotracker.app.data.database.HabitDao habitDao = null;
    
    public HabitRepository(@org.jetbrains.annotations.NotNull
    com.ecotracker.app.data.database.HabitDao habitDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ecotracker.app.data.model.EcoHabit>> getAllHabits() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ecotracker.app.data.model.EcoHabit>> getActiveHabits() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ecotracker.app.data.model.EcoHabit>> getCompletedHabits() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getHabitById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ecotracker.app.data.model.EcoHabit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertHabit(@org.jetbrains.annotations.NotNull
    com.ecotracker.app.data.model.EcoHabit habit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateHabit(@org.jetbrains.annotations.NotNull
    com.ecotracker.app.data.model.EcoHabit habit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteHabit(@org.jetbrains.annotations.NotNull
    com.ecotracker.app.data.model.EcoHabit habit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}