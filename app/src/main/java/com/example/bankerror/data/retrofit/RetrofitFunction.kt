package com.example.bankerror.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://developerhub.alfabank.by:8273/"
private fun getRetrofit() =
    Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

fun getApi(): Api = getRetrofit().create(Api::class.java)