package com.example.bankerror.data.model.ktor

import kotlinx.serialization.Serializable

@Serializable
data class RateResponseKtor(
    val buyCode: Int,
    val buyIso: String,
    val buyRate: Double,
    val date: String,
    val name: String?,
    val quantity: Int,
    val sellCode: Int,
    val sellIso: String,
    val sellRate: Double
)