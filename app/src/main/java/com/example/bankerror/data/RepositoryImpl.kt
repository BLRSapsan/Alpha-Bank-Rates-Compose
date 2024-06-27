package com.example.bankerror.data

import com.example.bankerror.data.model.RateResponse
import com.example.bankerror.data.model.RatesResponse
import com.example.bankerror.domain.Repository
import com.example.bankerror.domain.model.Rate

class RepositoryImpl (private val dataSource: DataSource): Repository {
    override suspend fun getRates(): Result<RatesResponse> {
        return dataSource.rateResponse()
    }
}

fun RateResponse.toDomain() = Rate(
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