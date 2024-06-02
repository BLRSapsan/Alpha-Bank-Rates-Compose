package com.example.bankerror.domain

import com.example.bankerror.domain.models.DataAlpha

interface RepositoryIn {
    suspend fun getListExchangeRatesAlpha(): DataAlpha
}