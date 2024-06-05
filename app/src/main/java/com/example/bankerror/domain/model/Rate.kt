package com.example.bankerror.domain.model

data class Rate(
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