package com.ecotracker.app.ui.fragments

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Long
import kotlin.jvm.JvmStatic

public data class HabitDetailFragmentArgs(
  public val habitId: Long = 0L,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putLong("habitId", this.habitId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("habitId", this.habitId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): HabitDetailFragmentArgs {
      bundle.setClassLoader(HabitDetailFragmentArgs::class.java.classLoader)
      val __habitId : Long
      if (bundle.containsKey("habitId")) {
        __habitId = bundle.getLong("habitId")
      } else {
        __habitId = 0L
      }
      return HabitDetailFragmentArgs(__habitId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): HabitDetailFragmentArgs {
      val __habitId : Long?
      if (savedStateHandle.contains("habitId")) {
        __habitId = savedStateHandle["habitId"]
        if (__habitId == null) {
          throw IllegalArgumentException("Argument \"habitId\" of type long does not support null values")
        }
      } else {
        __habitId = 0L
      }
      return HabitDetailFragmentArgs(__habitId)
    }
  }
}
