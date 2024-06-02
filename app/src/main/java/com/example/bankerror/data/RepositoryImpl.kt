package com.example.bankerror.data

import android.util.Log
import com.example.bankerror.RepositoryList
import com.example.bankerror.models.DataAlpha
import com.example.bankerror.TAGbank

const val BASE_URL = "https://developerhub.alfabank.by:8273/"
const val RATES_ALPHA_BANK = "partner/1.0.1/public/rates"
//const val ratesNationalBank = "partner/1.0.1/public/nationalRates?currencyCode=840,978"


class RepositoryImpl: RepositoryList {
    override suspend fun getListExchangeRatesAlpha(): DataAlpha {

        Log.i(TAGbank, "Repository.getRateAlpha: запрос в сеть АльфаБанкКурс")
        Log.i(
            TAGbank,
            "Repository.getRateAlpha: ответ JSON ${RetrofitObjectInstance.api.getAlpha()}"
        )
        return RetrofitObjectInstance.api.getAlpha()
    }
}