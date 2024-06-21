package com.example.bankerror.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bankerror.domain.RatesAlphaBankVM
import com.example.compose.CurrencyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
    Scaffold {
        Surface(modifier = Modifier.fillMaxSize()) {
            val ratesViewModel: RatesAlphaBankVM = viewModel()
            HomeScreen(
                rateUIState = ratesViewModel.rateUIState,
                retryAction = ratesViewModel::getRatesAlpha,
                contentPadding = it
            )
        }
    }
}