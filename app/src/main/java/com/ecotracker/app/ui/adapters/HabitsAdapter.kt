package com.ecotracker.app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ecotracker.app.R
import com.ecotracker.app.data.model.EcoHabit
import com.ecotracker.app.data.model.HabitCategory
import com.ecotracker.app.databinding.ItemHabitBinding

class HabitsAdapter(
    private val onHabitClick: (EcoHabit) -> Unit,
    private val onCompleteClick: (EcoHabit) -> Unit
) : ListAdapter<EcoHabit, HabitsAdapter.HabitViewHolder>(HabitDiffCallback()) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val binding = ItemHabitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HabitViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    
    inner class HabitViewHolder(
        private val binding: ItemHabitBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        
        fun bind(habit: EcoHabit) {
            binding.apply {
                tvHabitTitle.text = habit.title
                tvHabitDescription.text = habit.description
                
                // Calculate progress
                val progress = if (habit.targetValue > 0) {
                    ((habit.currentValue / habit.targetValue) * 100).toInt()
                } else 0
                
                progressHabit.progress = progress
                tvProgressText.text = "${habit.currentValue.toInt()}/${habit.targetValue.toInt()} ${habit.unit}"
                
                // Set category color
                val categoryColor = getCategoryColor(habit.category)
                categoryIndicator.setBackgroundColor(
                    ContextCompat.getColor(binding.root.context, categoryColor)
                )
                
                // Set completion state
                btnComplete.setImageResource(
                    if (habit.isCompleted) {
                        android.R.drawable.ic_menu_agenda
                    } else {
                        android.R.drawable.ic_menu_add
                    }
                )
                
                // Click listeners
                root.setOnClickListener { onHabitClick(habit) }
                btnComplete.setOnClickListener { onCompleteClick(habit) }
            }
        }
        
        private fun getCategoryColor(category: HabitCategory): Int {
            return when (category) {
                HabitCategory.WATER_CONSUMPTION -> R.color.category_water
                HabitCategory.ENERGY_SAVING -> R.color.category_energy
                HabitCategory.WASTE_REDUCTION -> R.color.category_waste
                HabitCategory.SUSTAINABLE_TRANSPORT -> R.color.category_transport
                HabitCategory.RECYCLING -> R.color.category_recycling
            }
        }
    }
    
    class HabitDiffCallback : DiffUtil.ItemCallback<EcoHabit>() {
        override fun areItemsTheSame(oldItem: EcoHabit, newItem: EcoHabit): Boolean {
            return oldItem.id == newItem.id
        }
        
        override fun areContentsTheSame(oldItem: EcoHabit, newItem: EcoHabit): Boolean {
            return oldItem == newItem
        }
    }
}
