package com.example.bankerror.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankerror.R
import com.example.bankerror.domain.model.Rate
import com.example.bankerror.ui.theme.components.BoxItem
import com.example.bankerror.ui.theme.components.SpacerItem

@Composable
fun ListRatesView(listRate: List<Rate>) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            @OptIn(ExperimentalMaterial3Api::class)
            (TopAppBar(
                title = { Text(stringResource(id = R.string.app_name), fontSize = 16.sp) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.DarkGray,
                    titleContentColor = Color.LightGray
                )
            ))
        },
    ) { innerPadding ->
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.LightGray)
        ) {
            item {
                HeadingView() //Заголовок: валютная пара, покупка, продажа
            }
            items(listRate) {
                ListItemCurrency(it)
            }
        }
    }
}

@Composable
fun ListItemCurrency(item: Rate) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .height(42.dp)
            .background(Color.White)
    ) {
        BoxItem(modifier = Modifier.weight(0.25f), text = item.sellIso)
        BoxItem(modifier = Modifier.weight(0.25f), text = item.buyIso)
        BoxItem(modifier = Modifier.weight(0.25f), text = item.buyRate.toString())
        BoxItem(modifier = Modifier.weight(0.25f), text = item.sellRate.toString())

        SpacerItem()
    }
}