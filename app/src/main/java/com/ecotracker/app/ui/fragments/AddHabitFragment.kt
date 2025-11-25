package com.ecotracker.app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ecotracker.app.R
import com.ecotracker.app.data.database.EcoTrackerDatabase
import com.ecotracker.app.data.model.EcoHabit
import com.ecotracker.app.data.model.HabitCategory
import com.ecotracker.app.data.repository.HabitRepository
import com.ecotracker.app.databinding.FragmentAddHabitBinding
import com.ecotracker.app.ui.viewmodel.HabitViewModel

class AddHabitFragment : Fragment() {
    
    private var _binding: FragmentAddHabitBinding? = null
    private val binding get() = _binding!!
    
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
        _binding = FragmentAddHabitBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupCategorySpinner()
        setupClickListeners()
        setupObservers()
    }
    
    private fun setupCategorySpinner() {
        val categories = listOf(
            "Consumo de Água",
            "Economia de Energia", 
            "Redução de Resíduos",
            "Transporte Sustentável",
            "Reciclagem"
        )
        
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            categories
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCategory.adapter = adapter
    }
    
    private fun setupClickListeners() {
        binding.btnSave.setOnClickListener {
            saveHabit()
        }
        
        binding.btnCancel.setOnClickListener {
            findNavController().navigateUp()
        }
    }
    
    private fun setupObservers() {
        viewModel.successMessage.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            findNavController().navigateUp()
        }
        
        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }
    
    private fun saveHabit() {
        val title = binding.etHabitTitle.text.toString().trim()
        val description = binding.etHabitDescription.text.toString().trim()
        val targetValue = binding.etTargetValue.text.toString().toDoubleOrNull() ?: 0.0
        val currentValue = binding.etCurrentValue.text.toString().toDoubleOrNull() ?: 0.0
        val unit = binding.etUnit.text.toString().trim()
        val categoryPosition = binding.spinnerCategory.selectedItemPosition
        
        if (title.isEmpty()) {
            binding.tilHabitTitle.error = "Título é obrigatório"
            return
        }
        
        if (description.isEmpty()) {
            binding.tilHabitDescription.error = "Descrição é obrigatória"
            return
        }
        
        if (targetValue <= 0) {
            binding.tilTargetValue.error = "Meta deve ser maior que zero"
            return
        }
        
        if (unit.isEmpty()) {
            binding.tilUnit.error = "Unidade é obrigatória"
            return
        }
        
        val category = when (categoryPosition) {
            0 -> HabitCategory.WATER_CONSUMPTION
            1 -> HabitCategory.ENERGY_SAVING
            2 -> HabitCategory.WASTE_REDUCTION
            3 -> HabitCategory.SUSTAINABLE_TRANSPORT
            4 -> HabitCategory.RECYCLING
            else -> HabitCategory.WATER_CONSUMPTION
        }
        
        val habit = EcoHabit(
            title = title,
            description = description,
            category = category,
            targetValue = targetValue,
            currentValue = currentValue,
            unit = unit
        )
        
        viewModel.addHabit(habit)
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
