package com.example.bankerror.data

import android.util.Log
import com.example.bankerror.data.model.RatesResponse
import com.example.bankerror.presentation.TAGbank
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


private const val GET_RATE = "https://developerhub.alfabank.by:8273/partner/1.0.1/public/rates/"

class DataSourceImplementation : DataSource {

    private lateinit var getResponseRates: RatesResponse

    override suspend fun rateResponse(): RatesResponse {
        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
        }

        try {
            getResponseRates = client.get(GET_RATE).body()
            Log.i(TAGbank, "RESPONSE Ktor: $getResponseRates")
        } catch (e: Exception) {
            Log.i(TAGbank, "Exception message: ${e.message}")
        } finally {
            client.close()
        }
        return getResponseRates
    }
}