package com.example.bankerror.domain

import com.example.bankerror.data.model.RatesResponse

interface Repository {
    suspend fun getRates(): Result <RatesResponse>
}