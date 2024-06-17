package com.example.bankerror.data

import com.example.bankerror.data.ktor.KtorResponse
import com.example.bankerror.data.model.ktor.RateResponseKtor
import com.example.bankerror.data.model.ktor.RatesResponseKtor
import com.example.bankerror.domain.Repository
import com.example.bankerror.domain.model.Rate

class RepositoryImplKtor (private val ktorResponse: KtorResponse): Repository {
    override suspend fun getRates(): RatesResponseKtor {
        return ktorResponse.rateResponse()
    }
}

fun RateResponseKtor.toDomain() = Rate(
    buyCode = buyCode,
    buyIso = buyIso,
    date = date,
    name = name,
    quantity = quantity,
    buyRate = buyRate,
    sellCode = sellCode,
    sellRate = sellRate,
    sellIso = sellIso
)