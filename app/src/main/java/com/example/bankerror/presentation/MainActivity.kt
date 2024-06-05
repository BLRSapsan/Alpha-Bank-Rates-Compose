package com.example.bankerror.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.bankerror.ui.theme.CurrencyTheme
import com.example.bankerror.utils.isConnect

const val TAGbank = "AlphaBankLog"
const val INTERNET_CHECK = 0
const val INTERNET_NOT_AVAILABLE = 1
const val INTERNET_AVAILABLE = 2

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CurrencyTheme {
                val changeScreenState = rememberSaveable { mutableStateOf(INTERNET_CHECK) }

                if (changeScreenState.value == INTERNET_CHECK) changeScreenState.value = isConnect()

                when (changeScreenState.value) {
                    INTERNET_NOT_AVAILABLE -> UnavailableScreen(mutableState = changeScreenState)
                    INTERNET_AVAILABLE -> AvailableScreen()
                }
            }
        }
    }
}