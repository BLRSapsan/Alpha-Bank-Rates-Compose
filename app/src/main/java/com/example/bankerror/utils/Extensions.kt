package com.example.bankerror.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.bankerror.presentation.INTERNET_AVAILABLE
import com.example.bankerror.presentation.INTERNET_NOT_AVAILABLE

@Composable
fun isConnect(): Int {
    val connectivityManager =
        LocalContext.current.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkCapabilities =
        connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    return when {
        networkCapabilities == null -> INTERNET_NOT_AVAILABLE
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> INTERNET_AVAILABLE
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> INTERNET_AVAILABLE
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> INTERNET_AVAILABLE
        else -> INTERNET_NOT_AVAILABLE
    }
}