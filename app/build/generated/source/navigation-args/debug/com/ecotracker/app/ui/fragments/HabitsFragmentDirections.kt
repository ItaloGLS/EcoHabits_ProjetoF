package com.ecotracker.app.ui.fragments

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.ecotracker.app.R
import kotlin.Int
import kotlin.Long

public class HabitsFragmentDirections private constructor() {
  private data class ActionHabitsToHabitDetail(
    public val habitId: Long = 0L,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_habits_to_habit_detail

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putLong("habitId", this.habitId)
        return result
      }
  }

  public companion object {
    public fun actionHabitsToAddHabit(): NavDirections =
        ActionOnlyNavDirections(R.id.action_habits_to_add_habit)

    public fun actionHabitsToHabitDetail(habitId: Long = 0L): NavDirections =
        ActionHabitsToHabitDetail(habitId)
  }
}
