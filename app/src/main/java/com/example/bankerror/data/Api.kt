package com.example.bankerror.data

import com.example.bankerror.domain.models.DataAlpha
import retrofit2.http.GET

interface Api {
    @GET(RATES_ALPHA_BANK)
    suspend fun getAlpha(): DataAlpha
}