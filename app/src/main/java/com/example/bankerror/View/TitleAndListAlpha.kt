package com.example.bankerror.View

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import com.example.bankerror.TAGbank
import com.example.bankerror.domain.BodyDataAlpha
import com.example.bankerror.domain.DataAlpha


//topBar and main page
//@Preview (widthDp = 300, heightDp = 50)
@Composable
fun TitleAppBar(listRate: List<DataAlpha>) {

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
                Heading()
            }

            itemsIndexed(listRate) { _, item ->

                val listRateNoId: List<List<BodyDataAlpha>> = listOf(item.rate)
                Log.i(TAGbank, "Содержание listRateNoId: $listRateNoId")

                for (i in listRateNoId) {
                    for (a in i) {
                        ListItemCurrency(itemFlow = a)
                    }
                }
            }
        }
    }
}

// состовляющие одной строки
//@Preview (widthDp = 300, heightDp = 50)
@Composable
fun ListItemCurrency(itemFlow: BodyDataAlpha) {

    Row(
        modifier = Modifier
            .fillMaxSize(fraction = 0.95f)
            .padding(4.dp)
            .height(42.dp)
            .background(Color.White)
    ) {

        Box( // 1 валюта
            modifier = Modifier
                .weight(weight = 0.25f)
        ) {
            Text(
                text = itemFlow.buyIso,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Box( //2валюта
            modifier = Modifier
                .weight(weight = 0.25f)
        ) {
            Text(
                text = itemFlow.sellIso,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Box( //курс продажи
            modifier = Modifier
                .weight(weight = 0.25f)
        ) {
            Text(
                text = itemFlow.sellRate.toString(),
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Box( //курс покупки
            modifier = Modifier
                .weight(weight = 0.25f)
        ) {
            Text(
                text = itemFlow.buyRate.toString(),
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))

    }
}