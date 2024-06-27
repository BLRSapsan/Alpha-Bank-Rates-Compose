package com.example.bankerror.data

import com.example.bankerror.data.model.RatesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

private const val GET_RATE = "https://developerhub.alfabank.by:8273/partner/1.0.1/public/rates/"

class DataSourceImplementation(private val httpClient: HttpClient) : DataSource {

    override suspend fun rateResponse(): Result<RatesResponse> {
        return kotlin.runCatching { httpClient.get(GET_RATE).body<RatesResponse>() }
    }
}