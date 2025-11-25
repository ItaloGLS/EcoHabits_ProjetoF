package com.ecotracker.app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecotracker.app.data.database.EcoTrackerDatabase
import com.ecotracker.app.data.repository.HabitRepository
import com.ecotracker.app.databinding.FragmentProgressBinding
import com.ecotracker.app.ui.adapters.HabitsAdapter
import com.ecotracker.app.ui.viewmodel.HabitViewModel
import kotlinx.coroutines.launch

class ProgressFragment : Fragment() {
    
    private var _binding: FragmentProgressBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var completedHabitsAdapter: HabitsAdapter
    
    private val viewModel: HabitViewModel by viewModels {
        val database = EcoTrackerDatabase.getDatabase(requireContext())
        val repository = HabitRepository(database.habitDao())
        HabitViewModel.Factory(repository)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgressBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        setupObservers()
    }
    
    private fun setupRecyclerView() {
        completedHabitsAdapter = HabitsAdapter(
            onHabitClick = { habit ->
                // Navigate to detail if needed
            },
            onCompleteClick = { habit ->
                val updatedHabit = habit.copy(isCompleted = !habit.isCompleted)
                viewModel.updateHabit(updatedHabit)
            }
        )
        
        binding.rvCompletedHabits.apply {
            adapter = completedHabitsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
    
    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.habits.collect { allHabits ->
                val completedHabits = allHabits.filter { it.isCompleted }
                val activeHabits = allHabits.filter { !it.isCompleted }
                
                // Update stats
                binding.tvCompletedCount.text = completedHabits.size.toString()
                binding.tvActiveCount.text = activeHabits.size.toString()
                
                // Update completed habits list
                completedHabitsAdapter.submitList(completedHabits)
                binding.tvEmptyState.visibility = if (completedHabits.isEmpty()) View.VISIBLE else View.GONE
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
