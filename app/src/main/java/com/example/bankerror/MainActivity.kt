package com.example.bankerror

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.example.bankerror.View.TitleAppBar
import com.example.bankerror.domain.DataAlpha
import com.example.bankerror.ui.theme.CurrencyTheme
import kotlinx.coroutines.flow.asStateFlow

const val TAGbank = "AlphaBankLog"

class MainActivity : ComponentActivity() {

    private val primeScreenStateFlow by viewModels<PrimeScreenStateFlow>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CurrencyTheme {
                primeScreenStateFlow.fetchItems()
                val listRate: List<DataAlpha> =primeScreenStateFlow.itemsStateFlow.asStateFlow().collectAsState().value
                //asStateFlow - Представляет этот изменяемый поток состояний как поток состояний, доступный только для чтения.
                //collectAsState - получить значения из потока.
                Log.i(TAGbank, "Main activity listRate: $listRate")

                TitleAppBar(listRate)

            }
        }
    }
}