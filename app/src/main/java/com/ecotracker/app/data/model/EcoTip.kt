package com.ecotracker.app.data.model

import com.google.gson.annotations.SerializedName

data class EcoTip(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("impact_level")
    val impactLevel: String,
    @SerializedName("difficulty")
    val difficulty: String
)
