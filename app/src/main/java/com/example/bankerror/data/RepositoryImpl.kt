package com.example.bankerror.data

import android.util.Log
import com.example.bankerror.domain.models.DataAlpha
import com.example.bankerror.TAGbank
import com.example.bankerror.domain.RepositoryIn

const val BASE_URL = "https://developerhub.alfabank.by:8273/"
const val RATES_ALPHA_BANK = "partner/1.0.1/public/rates"


class RepositoryImpl: RepositoryIn {
    override suspend fun getListExchangeRatesAlpha(): DataAlpha {

        Log.i(TAGbank, "RepositoryImpl.getListExchangeRatesAlpha: запрос в сеть АльфаБанкКурс")
        Log.i(
            TAGbank,
            "Ответ JSON ${RetrofitObjectInstance.api.getAlpha()}"
        )
        return RetrofitObjectInstance.api.getAlpha()
    }
}