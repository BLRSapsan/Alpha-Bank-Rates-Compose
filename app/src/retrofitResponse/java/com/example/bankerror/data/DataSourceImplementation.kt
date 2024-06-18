package com.example.bankerror.data

import com.example.bankerror.data.model.RatesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://developerhub.alfabank.by:8273/"

class DataSourceImplementation: DataSource {

    override suspend fun rateResponse(): RatesResponse {
        return getApi().getRates()
    }
}

private fun getRetrofit() =
    Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

fun getApi(): Api = getRetrofit().create(Api::class.java)

interface Api {
    @GET("partner/1.0.1/public/rates")
    suspend fun getRates(): RatesResponse
}