package com.example.bankerror.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private fun getRetrofit() =
    Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

fun getApi(): Api = getRetrofit().create(Api::class.java)