package com.example.bankerror.data.retrofit

import com.example.bankerror.data.model.retrofit.RatesResponse
import retrofit2.http.GET

interface Api {
    @GET("partner/1.0.1/public/rates")
    suspend fun getRates(): RatesResponse
}