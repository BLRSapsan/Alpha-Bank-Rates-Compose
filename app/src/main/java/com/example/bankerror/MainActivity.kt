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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.bankerror.View.MainViewAndListRate
import com.example.bankerror.View.UnavailableScreen
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

                val mutableState = remember { mutableStateOf(0) }
                Log.i(TAGbank, "Значение переменной valueMutableState: ${mutableState.value}")

                //использую это вместо 0 -> { IsInternetAvailable(mutableState = mutableState)}, т.к. так не прогружается экран
                //отсутсвия интернета, хотя mutableState принимает новые значения.
                if (mutableState.value == 0) {
                    IsInternetAvailable(mutableState = mutableState)
                }

                when (mutableState.value) {
//                  0 -> { IsInternetAvailable(mutableState = mutableState)}
                    1 -> {
                        UnavailableScreen(mutableState = mutableState)
                    }

                    2 -> {
                        primeScreenStateFlow.fetchItems()
                        val listRate: List<DataAlpha> =
                            primeScreenStateFlow.itemsStateFlow.asStateFlow().collectAsState().value
                        MainViewAndListRate(listRate = listRate)
                        //asStateFlow - Представляет этот изменяемый поток состояний как поток состояний, доступный только для чтения.
                        //collectAsState().value - получить значения из потока.
                        Log.i(TAGbank, "Main activity listRate: $listRate")
                    }
                }
            }
        }
    }
}

@Composable
    fun IsInternetAvailable(mutableState:MutableState<Int>) {
    Log.i(TAGbank, "ВЫЗОВ ФУНКЦИИ isInternetAvailable")
    val checkBoolean = isConnect()
    mutableState.value = if (checkBoolean){
        2
    } else {
        1
    }
    Log.i(TAGbank, "Ответ функции IsInternetAvailable: ${mutableState.value}")
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

