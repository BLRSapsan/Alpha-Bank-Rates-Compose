package com.example.bankerror.ui.theme.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.text.DecimalFormat

@Composable
fun BoxItem(
    modifier: Modifier = Modifier,
    text: String,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = text)
    }
}

@Composable
fun SpacerItem() {
    Spacer(modifier = Modifier.height(4.dp))
}


@Composable
fun CalculateBlock(rate: Double, modifier: Modifier) {

    var text by rememberSaveable { mutableStateOf("1.0") }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = if (it.isEmpty()) {
                    regex(it)
                } else {
                    when (it.toDoubleOrNull()) {
                        null -> text
                        else -> regex(it)
                    }
                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
        )
        val format = DecimalFormat("#.##").format(((text.toDoubleOrNull() ?: 0.0) * rate))
        Text(text = format.toString())
    }
}

fun regex(input: String): String {
    if (input.matches("0+".toRegex())) return "0"
    val regex = """^[0-9.]+${'$'}'""".toRegex()
    regex.matches(input)
    return input
}