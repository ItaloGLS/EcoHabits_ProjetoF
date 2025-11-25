package com.ecotracker.app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecotracker.app.data.api.ApiClient
import com.ecotracker.app.data.repository.EcoTipsRepository
import com.ecotracker.app.databinding.FragmentEcoTipsBinding
import com.ecotracker.app.ui.adapters.EcoTipsAdapter
import com.ecotracker.app.ui.viewmodel.EcoTipsViewModel
import kotlinx.coroutines.launch

class EcoTipsFragment : Fragment() {
    
    private var _binding: FragmentEcoTipsBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var tipsAdapter: EcoTipsAdapter
    
    private val viewModel: EcoTipsViewModel by viewModels {
        val repository = EcoTipsRepository(ApiClient.ecoTipsApiService)
        EcoTipsViewModel.Factory(repository)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEcoTipsBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        setupObservers()
        setupClickListeners()
    }
    
    private fun setupRecyclerView() {
        tipsAdapter = EcoTipsAdapter()
        
        binding.rvTips.apply {
            adapter = tipsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
    
    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.tips.collect { tips ->
                tipsAdapter.submitList(tips)
                binding.tvEmptyState.visibility = if (tips.isEmpty()) View.VISIBLE else View.GONE
            }
        }
        
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.dailyTip.collect { tip ->
                tip?.let {
                    binding.tvDailyTipContent.text = it.description
                    binding.cardDailyTip.visibility = View.VISIBLE
                } ?: run {
                    binding.cardDailyTip.visibility = View.GONE
                }
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
    }
    
    private fun setupClickListeners() {
        binding.btnRefresh.setOnClickListener {
            viewModel.refreshTips()
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
