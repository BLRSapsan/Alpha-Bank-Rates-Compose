package com.example.bankerror.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankerror.R

// шапка
@Preview
@Composable
fun HeadingView() {
    Row(
        modifier = Modifier
            .fillMaxSize(fraction = 0.95f)
            .padding(4.dp)
            .height(42.dp)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .weight(weight = 0.5f)
        ) {
            Text(
                text = stringResource(R.string.currency_para),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Box(
            modifier = Modifier
                .weight(weight = 0.25f)
        ) {
            Text(text = stringResource(R.string.sale), modifier = Modifier.align(Alignment.Center))
        }
        Box(
            modifier = Modifier
                .weight(weight = 0.25f)
        ) {
            Text(text = stringResource(R.string.buy), modifier = Modifier.align(Alignment.Center))
        }
        Spacer(modifier = Modifier.height(4.dp))
    }
}