package com.example.bankerror.presentation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.bankerror.domain.RatesAlphaBankVM
import com.example.bankerror.domain.model.Rate
import org.koin.androidx.compose.koinViewModel

@Composable
fun AvailableScreen(ratesAlphaBankVM: RatesAlphaBankVM = koinViewModel()) {

    val listRate: List<Rate> = ratesAlphaBankVM.itemsStateFlow.collectAsState().value

    if (listRate.isEmpty()) {
        ratesAlphaBankVM.getRatesAlpha()
    } else
        ListRatesView(listRate = listRate)
    Log.i(TAGbank, "AvailableScreen listRates: $listRate")

}