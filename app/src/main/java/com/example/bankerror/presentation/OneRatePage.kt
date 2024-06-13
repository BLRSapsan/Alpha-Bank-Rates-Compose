package com.example.bankerror.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.bankerror.R
import com.example.bankerror.domain.model.Rate
import com.example.bankerror.ui.theme.components.CalculateBox
import com.example.bankerror.ui.theme.components.SpacerItem

@Composable
fun OneRatePage(rate: Rate, onDismiss: () -> Unit, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(state = scrollState, true)
        ) {
            SpacerItem(modifier.height(4.dp))
            Text(text = stringResource(id = R.string.buy))
            CalculateBox(
                currencyFirst = rate.sellIso,
                currencySecond = rate.buyIso,
                rate = rate.sellRate,
                modifier = modifier
            )
            SpacerItem(modifier.height(20.dp))

            Text(text = stringResource(id = R.string.sale))
            CalculateBox(
                currencyFirst = rate.sellIso,
                currencySecond = rate.buyIso,
                rate = rate.buyRate,
                modifier = modifier
            )
            SpacerItem(modifier.height(20.dp))
            Button(onClick = onDismiss) {
                Text(text = stringResource(id = R.string.close))
            }
        }
    }
}