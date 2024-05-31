package com.example.bankerror

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.bankerror.ui.theme.CurrencyTheme
import com.example.bankerror.view.AvailableScreen
import com.example.bankerror.view.UnavailableScreen

const val TAGbank = "AlphaBankLog"

class MainActivity : ComponentActivity() {

    private val ratesAlphaBankVM by viewModels<RatesAlphaBankVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CurrencyTheme {
                //переменная, идентифицирующее состояние composable
                val changeScreenStateInt = remember { mutableStateOf(0) }
                if (changeScreenStateInt.value==0){ IsInternetAvailable(mutableStateInt = changeScreenStateInt) }

                when (changeScreenStateInt.value) {
                    1 -> UnavailableScreen(mutableState = changeScreenStateInt)
                    2 -> AvailableScreen(ratesAlphaBankVM = ratesAlphaBankVM)
                }
            }
        }
    }
}


@Composable
fun IsInternetAvailable(mutableStateInt:MutableState<Int>) {
    Log.i(TAGbank, "ВЫЗОВ ФУНКЦИИ isInternetAvailable")
    val checkConnectBoolean = isConnect()
    mutableStateInt.value = if (checkConnectBoolean){
        2 //страница курса валют
    } else {
        1   //страница нет доступа в интернет
    }
    Log.i(TAGbank, "Ответ функции IsInternetAvailable: ${mutableStateInt.value}")
}

@Composable
fun isConnect(): Boolean {
    Log.i(TAGbank, "ВЫЗОВ ФУНКЦИИ isConnect")
    val context = LocalContext.current
    var result: Boolean = false
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    //получить активное соединение. Ответ null, если их нет.
    val networkCapabilities = connectivityManager.activeNetwork ?: return result
    //получить свойства доступного соединения.
    val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return result
    result = when {
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
        else -> false
    }
    return result
}
