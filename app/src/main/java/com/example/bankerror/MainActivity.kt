package com.example.bankerror

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankerror.domain.BodyDataAlpha
import com.example.bankerror.domain.DataAlpha
import com.example.bankerror.ui.theme.BankErrorTheme
import kotlinx.coroutines.flow.asStateFlow

const val TAGbank = "AlphaBankLog"

class MainActivity : ComponentActivity() {

    private val primeScreenStateFlow by viewModels<PrimeScreenStateFlow>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankErrorTheme {

                primeScreenStateFlow.fetchItems()
                val listRate: List<DataAlpha> =primeScreenStateFlow.itemsStateFlow.asStateFlow().collectAsState().value

                //asStateFlow - Представляет этот изменяемый поток состояний как поток состояний, доступный только для чтения.
                //collectAsState - получить значения из потока

                //Log.i(TAGbank, "Main activity listStateFlow: $listStateFlow")

                TitleAppBar(listRate)
            }
        }
    }
}

//topBar and main page
//@Preview (widthDp = 300, heightDp = 50)
@Composable
fun TitleAppBar(listRate: List<DataAlpha>) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            @OptIn(ExperimentalMaterial3Api::class)
            TopAppBar(
                title = { Text("Rate Compose", fontSize = 16.sp) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.DarkGray,
                    titleContentColor = Color.LightGray
                )
            )
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
                TitleCurrency()
            }
            itemsIndexed(listRate){
                _, item ->
                ListItemCurrency(itemFlow = item.rate)
                Log.i(TAGbank, "Данные для каждой отдельной строки ${item.rate}")
            }
        }
    }
}

// состовляющие одной строки
//@Preview (widthDp = 300, heightDp = 50)
@Composable
fun ListItemCurrency(itemFlow:List<BodyDataAlpha>) {

    Row(
        modifier = Modifier
            .fillMaxSize(fraction = 0.95f)
            .padding(4.dp)
            .height(42.dp)
            .background(Color.White)
    ) {

        Box( // 1 валюта
            modifier = Modifier
                .aspectRatio(1.0f, matchHeightConstraintsFirst = true)
                .weight(weight = 0.25f)
        ) {
            Text(
                text = stringResource(R.string.usd),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Box( //2валюта
            modifier = Modifier
                .aspectRatio(1.0f, matchHeightConstraintsFirst = true)
                .weight(weight = 0.25f)
        ) {
            Text(
                text = stringResource(R.string.byn),
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Box( //курс продажи
            modifier = Modifier
                .aspectRatio(1.0f, matchHeightConstraintsFirst = true)
                .weight(weight = 0.25f)
        ) {
            Text(
                text = stringResource(R.string.sale),
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Box( //курс покупки
            modifier = Modifier
                .aspectRatio(1.0f, matchHeightConstraintsFirst = true)
                .weight(weight = 0.25f)
        ) {
            Text(
                text = stringResource(R.string.buy),
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
    }
}

// шапка
@Preview
@Composable
fun TitleCurrency() {
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
