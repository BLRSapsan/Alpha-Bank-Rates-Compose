package com.example.bankerror

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.bankerror.ui.theme.CurrencyTheme
import com.example.bankerror.presentation.AvailableScreen
import com.example.bankerror.presentation.UnavailableScreen

const val TAGbank = "AlphaBankLog"

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CurrencyTheme {
                //переменная changeScreenStateInt, идентифицирует состояние composable.
                //rememberSaveable - сохраняет значение при повроте экрана. Обычное rememer этого не делает.
                val changeScreenStateInt = rememberSaveable { mutableStateOf(0) }
                if (changeScreenStateInt.value == 0) { IsInternetAvailable(mutableStateInt = changeScreenStateInt) }

                when (changeScreenStateInt.value) {
                    1 -> UnavailableScreen(mutableState = changeScreenStateInt)
                    2 -> AvailableScreen()
                }
            }
        }
    }
}