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
import androidx.navigation.fragment.navArgs
import com.ecotracker.app.data.database.EcoTrackerDatabase
import com.ecotracker.app.data.model.EcoHabit
import com.ecotracker.app.data.model.HabitCategory
import com.ecotracker.app.data.repository.HabitRepository
import com.ecotracker.app.databinding.FragmentHabitDetailBinding
import com.ecotracker.app.ui.viewmodel.HabitViewModel
import kotlinx.coroutines.launch

class HabitDetailFragment : Fragment() {
    
    private var _binding: FragmentHabitDetailBinding? = null
    private val binding get() = _binding!!
    
    private val args: HabitDetailFragmentArgs by navArgs()
    private var currentHabit: EcoHabit? = null
    
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
        _binding = FragmentHabitDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        loadHabitDetails()
        setupClickListeners()
        setupObservers()
    }
    
    private fun loadHabitDetails() {
        viewLifecycleOwner.lifecycleScope.launch {
            val habit = viewModel.getHabitById(args.habitId)
            habit?.let {
                currentHabit = it
                displayHabitDetails(it)
            } ?: run {
                Toast.makeText(requireContext(), "Hábito não encontrado", Toast.LENGTH_SHORT).show()
                findNavController().navigateUp()
            }
        }
    }
    
    private fun displayHabitDetails(habit: EcoHabit) {
        binding.apply {
            tvHabitTitle.text = habit.title
            tvHabitDescription.text = habit.description
            tvCategory.text = getCategoryDisplayName(habit.category)
            
            // Calculate and display progress
            val progress = if (habit.targetValue > 0) {
                ((habit.currentValue / habit.targetValue) * 100).toInt()
            } else 0
            
            progressHabit.progress = progress
            tvProgressText.text = "${habit.currentValue.toInt()}/${habit.targetValue.toInt()} ${habit.unit} ($progress%)"
            
            // Set current value in edit text
            etUpdateValue.setText(habit.currentValue.toString())
            
            // Update button text based on completion status
            btnComplete.text = if (habit.isCompleted) "Marcar como Ativo" else "Marcar como Concluído"
        }
    }
    
    private fun getCategoryDisplayName(category: HabitCategory): String {
        return when (category) {
            HabitCategory.WATER_CONSUMPTION -> "Consumo de Água"
            HabitCategory.ENERGY_SAVING -> "Economia de Energia"
            HabitCategory.WASTE_REDUCTION -> "Redução de Resíduos"
            HabitCategory.SUSTAINABLE_TRANSPORT -> "Transporte Sustentável"
            HabitCategory.RECYCLING -> "Reciclagem"
        }
    }
    
    private fun setupClickListeners() {
        binding.btnUpdate.setOnClickListener {
            updateHabitProgress()
        }
        
        binding.btnComplete.setOnClickListener {
            toggleHabitCompletion()
        }
        
        binding.btnDelete.setOnClickListener {
            deleteHabit()
        }
    }
    
    private fun setupObservers() {
        viewModel.successMessage.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            if (message.contains("removido")) {
                findNavController().navigateUp()
            } else {
                loadHabitDetails() // Reload to show updated data
            }
        }
        
        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }
    
    private fun updateHabitProgress() {
        val newValue = binding.etUpdateValue.text.toString().toDoubleOrNull()
        if (newValue == null) {
            binding.tilUpdateValue.error = "Valor inválido"
            return
        }
        
        currentHabit?.let { habit ->
            val updatedHabit = habit.copy(currentValue = newValue)
            viewModel.updateHabit(updatedHabit)
        }
    }
    
    private fun toggleHabitCompletion() {
        currentHabit?.let { habit ->
            val updatedHabit = habit.copy(isCompleted = !habit.isCompleted)
            viewModel.updateHabit(updatedHabit)
        }
    }
    
    private fun deleteHabit() {
        currentHabit?.let { habit ->
            viewModel.deleteHabit(habit)
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
