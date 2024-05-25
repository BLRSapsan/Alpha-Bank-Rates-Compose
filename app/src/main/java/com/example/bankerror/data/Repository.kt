package com.example.bankerror.data

import android.util.Log
import com.example.bankerror.domain.DataAlpha
import com.example.bankerror.TAGbank

const val BASE_URL = "https://developerhub.alfabank.by:8273/"
const val ratesAlphaBank = "partner/1.0.1/public/rates"
const val ratesNationalBank = "partner/1.0.1/public/nationalRates?currencyCode=840,978"

class Repository {
    suspend fun getRateAlpha(): DataAlpha {
        Log.i(TAGbank, "Repository.getRateAlpha: запрос в сеть АльфаКурс")
        Log.i(
            TAGbank,"Repository.getRateAlpha: ответ JSON ${RetrofitObjectInstance.api.getAlpha()}"
        )
        return RetrofitObjectInstance.api.getAlpha()
    }
}