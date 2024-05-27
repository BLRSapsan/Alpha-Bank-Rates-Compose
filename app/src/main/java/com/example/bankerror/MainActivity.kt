package com.example.bankerror

import android.app.Activity
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankerror.View.TitleAppBar
import com.example.bankerror.domain.DataAlpha
import com.example.bankerror.ui.theme.CurrencyTheme
import kotlinx.coroutines.flow.asStateFlow

const val TAGbank = "AlphaBankLog"

class MainActivity : ComponentActivity() {

    private val primeScreenStateFlow by viewModels<PrimeScreenStateFlow>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CurrencyTheme {
                //                if (isInternetAvailable()) {
//                    primeScreenStateFlow.fetchItems()
//                    val listRate: List<DataAlpha> =
//                        primeScreenStateFlow.itemsStateFlow.asStateFlow().collectAsState().value
//                    TitleAppBar(listRate = listRate)
//                    //asStateFlow - Представляет этот изменяемый поток состояний как поток состояний, доступный только для чтения.
//                    //collectAsState().value - получить значения из потока.
//                    Log.i(TAGbank, "Main activity listRate: $listRate")
//                } else UnavailableScreen()
                PageChange()
            }
        }
    }


    @Composable
    fun PageChange() {
        if (isInternetAvailable()) {
            primeScreenStateFlow.fetchItems()
            val listRate: List<DataAlpha> =
                primeScreenStateFlow.itemsStateFlow.asStateFlow().collectAsState().value
            TitleAppBar(listRate = listRate)
            //asStateFlow - Представляет этот изменяемый поток состояний как поток состояний, доступный только для чтения.
            //collectAsState().value - получить значения из потока.
            Log.i(TAGbank, "Main activity listRate: $listRate")
        } else UnavailableScreen()
    }


    @Composable
    fun UnavailableScreen () {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_accessible_forward_24),
                contentDescription = "Internet OFF",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Internet is OFF", fontSize = 18.sp)

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedButton(onClick = { /*TODO*/}) {
                Text(text = stringResource(id = R.string.repeat))
            }
        }
    }
}

@Composable
fun isInternetAvailable(): Boolean {
    val context = LocalContext.current
    var result = false
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkCapabilities = connectivityManager.activeNetwork ?: return false
    val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
    result = when {
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
        else -> false
    }
    return result
}
