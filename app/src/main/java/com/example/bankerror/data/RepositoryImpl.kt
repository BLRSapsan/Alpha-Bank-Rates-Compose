//package com.example.bankerror.data
//
//import android.util.Log
//import com.example.bankerror.data.model.retrofit.RatesResponse
//import com.example.bankerror.data.model.retrofit.RateResponse
//import com.example.bankerror.data.retrofit.Api
//import com.example.bankerror.presentation.TAGbank
//import com.example.bankerror.domain.Repository
//import com.example.bankerror.domain.model.Rate
//
//
//class RepositoryImpl(private val api: Api) : Repository {
//    override suspend fun getRates(): RatesResponse {
//        val rates = api.getRates()
//        Log.i(TAGbank, "RepositoryImpl.getRates: запрос в сеть \n Ответ JSON ${rates}")
//        return rates
//    }
//}
//
//fun RateResponse.toDomain() = Rate(
//    buyCode = buyCode,
//    buyIso = buyIso,
//    date = date,
//    name = name,
//    quantity = quantity,
//    buyRate = buyRate,
//    sellCode = sellCode,
//    sellRate = sellRate,
//    sellIso = sellIso
//)