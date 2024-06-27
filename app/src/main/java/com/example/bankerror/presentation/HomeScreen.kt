package com.example.bankerror.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.bankerror.R

@Composable
fun HomeScreen(
    rateUIState: RateUIState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
) {
    when (rateUIState) {
        is RateUIState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is RateUIState.Error -> ErrorScreen(retryAction, modifier = modifier.fillMaxSize())
        is RateUIState.RateList -> ListRatesView(
            listRate = rateUIState.rate,
            modifier = modifier.fillMaxSize()
        )
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.baseline_cached_24),
        contentDescription = stringResource(R.string.loading)
    )
}