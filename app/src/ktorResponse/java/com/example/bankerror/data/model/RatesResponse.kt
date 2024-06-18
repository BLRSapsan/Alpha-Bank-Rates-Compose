package com.example.bankerror.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RatesResponse(@SerialName("rates") val rate:List<RateResponse>)
