package com.ecotracker.app.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001(B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000bJ\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000bJ\u001b\u0010!\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\"\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\u001eH\u0002J\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u000fJ\u000e\u0010\'\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lcom/ecotracker/app/ui/viewmodel/HabitViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/ecotracker/app/data/repository/HabitRepository;", "(Lcom/ecotracker/app/data/repository/HabitRepository;)V", "_errorMessage", "Lcom/ecotracker/app/utils/SingleLiveEvent;", "", "_habits", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/ecotracker/app/data/model/EcoHabit;", "_isLoading", "", "_navigateToDetail", "", "_successMessage", "errorMessage", "getErrorMessage", "()Lcom/ecotracker/app/utils/SingleLiveEvent;", "habits", "Lkotlinx/coroutines/flow/StateFlow;", "getHabits", "()Lkotlinx/coroutines/flow/StateFlow;", "isLoading", "navigateToDetail", "getNavigateToDetail", "successMessage", "getSuccessMessage", "addHabit", "", "habit", "deleteHabit", "getHabitById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadHabits", "onHabitClicked", "habitId", "updateHabit", "Factory", "app_debug"})
public final class HabitViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.ecotracker.app.data.repository.HabitRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.ecotracker.app.data.model.EcoHabit>> _habits = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ecotracker.app.data.model.EcoHabit>> habits = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final com.ecotracker.app.utils.SingleLiveEvent<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull
    private final com.ecotracker.app.utils.SingleLiveEvent<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull
    private final com.ecotracker.app.utils.SingleLiveEvent<java.lang.String> _successMessage = null;
    @org.jetbrains.annotations.NotNull
    private final com.ecotracker.app.utils.SingleLiveEvent<java.lang.String> successMessage = null;
    @org.jetbrains.annotations.NotNull
    private final com.ecotracker.app.utils.SingleLiveEvent<java.lang.Long> _navigateToDetail = null;
    @org.jetbrains.annotations.NotNull
    private final com.ecotracker.app.utils.SingleLiveEvent<java.lang.Long> navigateToDetail = null;
    
    public HabitViewModel(@org.jetbrains.annotations.NotNull
    com.ecotracker.app.data.repository.HabitRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ecotracker.app.data.model.EcoHabit>> getHabits() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ecotracker.app.utils.SingleLiveEvent<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ecotracker.app.utils.SingleLiveEvent<java.lang.String> getSuccessMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ecotracker.app.utils.SingleLiveEvent<java.lang.Long> getNavigateToDetail() {
        return null;
    }
    
    private final void loadHabits() {
    }
    
    public final void addHabit(@org.jetbrains.annotations.NotNull
    com.ecotracker.app.data.model.EcoHabit habit) {
    }
    
    public final void updateHabit(@org.jetbrains.annotations.NotNull
    com.ecotracker.app.data.model.EcoHabit habit) {
    }
    
    public final void deleteHabit(@org.jetbrains.annotations.NotNull
    com.ecotracker.app.data.model.EcoHabit habit) {
    }
    
    public final void onHabitClicked(long habitId) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getHabitById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ecotracker.app.data.model.EcoHabit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/ecotracker/app/ui/viewmodel/HabitViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "repository", "Lcom/ecotracker/app/data/repository/HabitRepository;", "(Lcom/ecotracker/app/data/repository/HabitRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
    public static final class Factory implements androidx.lifecycle.ViewModelProvider.Factory {
        @org.jetbrains.annotations.NotNull
        private final com.ecotracker.app.data.repository.HabitRepository repository = null;
        
        public Factory(@org.jetbrains.annotations.NotNull
        com.ecotracker.app.data.repository.HabitRepository repository) {
            super();
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull
        java.lang.Class<T> modelClass) {
            return null;
        }
    }
}