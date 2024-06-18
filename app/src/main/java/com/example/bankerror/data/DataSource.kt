package com.example.bankerror.data

import com.example.bankerror.data.model.RatesResponse

interface DataSource {
    suspend fun rateResponse(): RatesResponse
}