package com.example.bankerror.data

import com.example.bankerror.data.model.RatesResponse
import retrofit2.http.GET

interface Api {
    @GET("partner/1.0.1/public/rates")
    suspend fun getRates(): RatesResponse
}