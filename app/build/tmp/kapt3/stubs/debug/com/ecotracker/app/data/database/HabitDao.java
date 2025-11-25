package com.ecotracker.app.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u001b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/ecotracker/app/data/database/HabitDao;", "", "deleteHabit", "", "habit", "Lcom/ecotracker/app/data/model/EcoHabit;", "(Lcom/ecotracker/app/data/model/EcoHabit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveHabits", "Lkotlinx/coroutines/flow/Flow;", "", "getAllHabits", "getCompletedHabits", "getHabitById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertHabit", "updateHabit", "app_debug"})
@androidx.room.Dao
public abstract interface HabitDao {
    
    @androidx.room.Query(value = "SELECT * FROM eco_habits ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.ecotracker.app.data.model.EcoHabit>> getAllHabits();
    
    @androidx.room.Query(value = "SELECT * FROM eco_habits WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHabitById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ecotracker.app.data.model.EcoHabit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertHabit(@org.jetbrains.annotations.NotNull
    com.ecotracker.app.data.model.EcoHabit habit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateHabit(@org.jetbrains.annotations.NotNull
    com.ecotracker.app.data.model.EcoHabit habit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteHabit(@org.jetbrains.annotations.NotNull
    com.ecotracker.app.data.model.EcoHabit habit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM eco_habits WHERE isCompleted = 0")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.ecotracker.app.data.model.EcoHabit>> getActiveHabits();
    
    @androidx.room.Query(value = "SELECT * FROM eco_habits WHERE isCompleted = 1")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.ecotracker.app.data.model.EcoHabit>> getCompletedHabits();
}