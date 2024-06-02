package com.example.bankerror.presentation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.bankerror.domain.RatesAlphaBankVM
import com.example.bankerror.TAGbank
import com.example.bankerror.domain.models.DataAlpha
import kotlinx.coroutines.flow.asStateFlow
import org.koin.androidx.compose.koinViewModel

@Composable
fun AvailableScreen(ratesAlphaBankVM: RatesAlphaBankVM = koinViewModel()) {

    val listRates: List<DataAlpha> =
        ratesAlphaBankVM.itemsStateFlow.asStateFlow().collectAsState().value
    //asStateFlow - Представляет этот изменяемый поток состояний как поток состояний, доступный только для чтения.
    //collectAsState().value - получить значения из потока.
    if (listRates.isEmpty()) {
        ratesAlphaBankVM.getRatesAlpha()
    } else
        ListRatesView(listRates = listRates)

    Log.i(TAGbank, "AvailableScreen listRates: $listRates")
}