package com.example.bankerror

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.platform.LocalContext

@Composable
fun IsInternetAvailable(mutableStateInt: MutableState<Int>) {
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
    val context = LocalContext.current
    var result = false
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