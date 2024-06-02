package com.example.bankerror.data

import com.example.bankerror.models.DataAlpha

interface RepositoryList {
    suspend fun getListExchangeRatesAlpha():DataAlpha
}