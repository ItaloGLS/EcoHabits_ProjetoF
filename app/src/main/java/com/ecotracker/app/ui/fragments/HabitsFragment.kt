package com.ecotracker.app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecotracker.app.data.api.ApiClient
import com.ecotracker.app.data.database.EcoTrackerDatabase
import com.ecotracker.app.data.repository.HabitRepository
import com.ecotracker.app.databinding.FragmentHabitsBinding
import com.ecotracker.app.ui.adapters.HabitsAdapter
import com.ecotracker.app.ui.viewmodel.HabitViewModel
import kotlinx.coroutines.launch

class HabitsFragment : Fragment() {
    
    private var _binding: FragmentHabitsBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var habitsAdapter: HabitsAdapter
    
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
        _binding = FragmentHabitsBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        setupObservers()
        setupClickListeners()
    }
    
    private fun setupRecyclerView() {
        habitsAdapter = HabitsAdapter(
            onHabitClick = { habit ->
                viewModel.onHabitClicked(habit.id)
            },
            onCompleteClick = { habit ->
                val updatedHabit = habit.copy(isCompleted = !habit.isCompleted)
                viewModel.updateHabit(updatedHabit)
            }
        )
        
        binding.rvHabits.apply {
            adapter = habitsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
    
    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.habits.collect { habits ->
                habitsAdapter.submitList(habits)
                binding.tvEmptyState.visibility = if (habits.isEmpty()) View.VISIBLE else View.GONE
            }
        }
        
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.isLoading.collect { isLoading ->
                binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            }
        }
        
        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
        
        viewModel.successMessage.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
        
        viewModel.navigateToDetail.observe(viewLifecycleOwner) { habitId ->
            val action = HabitsFragmentDirections.actionHabitsToHabitDetail(habitId)
            findNavController().navigate(action)
        }
    }
    
    private fun setupClickListeners() {
        binding.fabAddHabit.setOnClickListener {
            findNavController().navigate(HabitsFragmentDirections.actionHabitsToAddHabit())
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
