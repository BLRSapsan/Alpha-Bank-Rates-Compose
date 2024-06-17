package com.example.bankerror.data.model.ktor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RatesResponseKtor(@SerialName("rates") val rate:List<RateResponseKtor>)
