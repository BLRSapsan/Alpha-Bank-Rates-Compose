package com.example.bankerror.View

import android.util.Log
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
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankerror.R
import com.example.bankerror.TAGbank

@Composable
fun UnavailableScreen(mutableState: MutableState<Int>) {
    Log.i(TAGbank, "Загрузка экрана *Нет доступа к сети*")
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

        OutlinedButton(onClick =  { mutableState.value = 0 }) {
            Text(text = stringResource(id = R.string.repeat))
        }
    }
}