package com.example.bankerror.view

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.bankerror.RatesAlphaBankVM
import com.example.bankerror.TAGbank
import com.example.bankerror.models.DataAlpha
import kotlinx.coroutines.flow.asStateFlow
import org.koin.androidx.compose.koinViewModel

@Composable
fun AvailableScreen(ratesAlphaBankVM: RatesAlphaBankVM = koinViewModel()) {

    ratesAlphaBankVM.getRatesAlpha()
    val listRates: List<DataAlpha> =
        ratesAlphaBankVM.itemsStateFlow.asStateFlow().collectAsState().value
    ListRatesView(listRates = listRates)
    //asStateFlow - Представляет этот изменяемый поток состояний как поток состояний, доступный только для чтения.
    //collectAsState().value - получить значения из потока.
    Log.i(TAGbank, "Main activity listRates: $listRates")
}