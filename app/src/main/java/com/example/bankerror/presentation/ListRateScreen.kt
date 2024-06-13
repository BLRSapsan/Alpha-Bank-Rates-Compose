package com.example.bankerror.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bankerror.domain.model.Rate
import com.example.bankerror.presentation.components.BoxItem
import com.example.bankerror.presentation.components.SpacerItem

@Composable
fun ListRatesView(listRate: List<Rate>, modifier: Modifier) {

    val rateIndex = rememberSaveable { mutableStateOf<Int?>(null) }

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            userScrollEnabled = true,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            item {
                HeadingView()
            }
            itemsIndexed(listRate) { index, item ->
                ListItemCurrency(
                    item = item,
                    modifier = Modifier.clickable {
                        rateIndex.value = index
                    }
                )
            }
        }
    }
    if (rateIndex.value != null) {
        OneRatePage(
            rate = listRate[rateIndex.value!!],
            onDismiss = { rateIndex.value = null }
        )
    }
}

@Composable
fun ListItemCurrency(item: Rate, modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp)
            .height(42.dp)
    ) {
        BoxItem(modifier = modifier.weight(0.2f), text = item.sellIso)
        BoxItem(modifier = modifier.weight(0.2f), text = item.buyIso)
        BoxItem(modifier = modifier.weight(0.3f), text = item.buyRate.toString())
        BoxItem(modifier = modifier.weight(0.3f), text = item.sellRate.toString())
        SpacerItem(modifier.height(4.dp))
    }
}