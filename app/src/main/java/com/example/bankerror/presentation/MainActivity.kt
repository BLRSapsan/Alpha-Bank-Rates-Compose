package com.example.bankerror.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bankerror.ui.theme.CurrencyTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CurrencyTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    RateApp()
                }
            }
        }
    }
}

@Composable
fun RateApp() {
    Scaffold { innerPadding ->
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            val ratesViewModel: RatesAlphaBankVM = koinViewModel()
            HomeScreen(
                rateUIState = ratesViewModel.rateUIState,
                retryAction = ratesViewModel::getRatesAlpha,
            )
        }
    }
}