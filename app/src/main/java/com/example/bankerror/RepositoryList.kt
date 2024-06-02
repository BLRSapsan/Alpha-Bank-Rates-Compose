package com.example.bankerror

import com.example.bankerror.models.DataAlpha

interface RepositoryList {
    suspend fun getListExchangeRatesAlpha():DataAlpha
}