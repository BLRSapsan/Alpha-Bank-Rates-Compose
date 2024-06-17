package com.example.bankerror.domain

import com.example.bankerror.data.model.ktor.RatesResponseKtor
import com.example.bankerror.data.model.retrofit.RatesResponse

//interface Repository {
//    suspend fun getRates(): RatesResponse
//}

interface Repository {
    suspend fun getRates(): RatesResponseKtor
}