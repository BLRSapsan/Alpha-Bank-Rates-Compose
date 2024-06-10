package com.example.bankerror.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankerror.R
import com.example.bankerror.domain.model.Rate
import androidx.compose.ui.input.key.Key
import com.example.bankerror.ui.theme.components.CalculateBlock

@Composable
fun OneRatePage(rate: Rate, onDismiss: () -> Unit, modifier: Modifier = Modifier) {

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
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.LightGray)
        ) {

            Row {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier.weight(0.3f)
                ) {
                    Text(text = rate.sellIso, fontSize = 40.sp)
                    Text(text = rate.buyIso, fontSize = 40.sp)
                }

                CalculateBlock(
                    rate = rate.sellRate,
                    modifier = modifier.weight(0.35f)

                )
                CalculateBlock(
                    rate = rate.buyRate,
                    modifier = modifier.weight(0.35f)

                )
            }
            Scrim(onClose = onDismiss, modifier = Modifier)
        }
    }
}

@Composable
fun Scrim(onClose: () -> Unit, modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center,
        modifier = modifier
            .height(200.dp)
            .width(200.dp)
            .pointerInput(onClose) { detectTapGestures { onClose() } }
            .semantics(mergeDescendants = true) {
                onClick {
                    onClose()
                    true
                }
            }
            .onKeyEvent {
                if (it.key == Key.Escape) {
                    onClose()
                    true
                } else {
                    false
                }
            }
            .background(Color.DarkGray.copy(alpha = 0.75f))
    ) {
        Text(text = "CLOSE")
    }
}

//pointerInput - обработчик нажатий. переменная onClose для него - это ключ.
// Когда значение одного из этих ключей изменяется, лямбда-выражение содержимого модификатора выполняется повторно.

//detectTapGestures -Обнаруживает жесты касания, двойного касания и длительного нажатия
// и вызывает onTap, onDoubleTapи onLongPress

//semantics - семантика  представляет из себя сеть, в который каждый элемент занимает свою позицию в общей сети.

//Modifier.semantics (mergeDescendants = true) {}.
// Установка этого свойства в значение true указывает, что свойства семантики следует объединить.

//onKeyEvent - Добавление этого параметра к modifier параметру компонента позволит ему перехватывать
// события аппаратных клавиш, когда он (или один из его дочерних элементов) находится в фокусе.