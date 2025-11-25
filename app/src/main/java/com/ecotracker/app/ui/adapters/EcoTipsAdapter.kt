package com.ecotracker.app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ecotracker.app.R
import com.ecotracker.app.data.model.EcoTip
import com.ecotracker.app.databinding.ItemEcoTipBinding

class EcoTipsAdapter : ListAdapter<EcoTip, EcoTipsAdapter.TipViewHolder>(TipDiffCallback()) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val binding = ItemEcoTipBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TipViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    
    inner class TipViewHolder(
        private val binding: ItemEcoTipBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        
        fun bind(tip: EcoTip) {
            binding.apply {
                tvTipTitle.text = tip.title
                tvTipDescription.text = tip.description
                tvTipCategory.text = tip.category
                tvTipDifficulty.text = tip.difficulty
                tvTipImpact.text = tip.impactLevel
                
                // Set difficulty color
                val difficultyColor = when (tip.difficulty.lowercase()) {
                    "fácil", "easy" -> R.color.success
                    "médio", "medium" -> R.color.warning
                    "difícil", "hard" -> R.color.error
                    else -> R.color.text_secondary
                }
                
                tvTipDifficulty.setBackgroundColor(
                    ContextCompat.getColor(binding.root.context, difficultyColor)
                )
            }
        }
    }
    
    class TipDiffCallback : DiffUtil.ItemCallback<EcoTip>() {
        override fun areItemsTheSame(oldItem: EcoTip, newItem: EcoTip): Boolean {
            return oldItem.id == newItem.id
        }
        
        override fun areContentsTheSame(oldItem: EcoTip, newItem: EcoTip): Boolean {
            return oldItem == newItem
        }
    }
}
