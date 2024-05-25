package com.example.bankerror.data

import com.example.bankerror.domain.DataAlpha
import retrofit2.http.GET

interface Api {
    @GET(ratesAlphaBank)
    suspend fun getAlpha(): DataAlpha
}