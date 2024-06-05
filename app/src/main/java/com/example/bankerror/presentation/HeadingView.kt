package com.example.bankerror.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankerror.R
import com.example.bankerror.ui.theme.components.BoxItem
import com.example.bankerror.ui.theme.components.SpacerItem

@Preview
@Composable
fun HeadingView(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .height(42.dp)
            .background(Color.White)
    ) {
        BoxItem(modifier = Modifier.weight(0.5f), text = stringResource(R.string.currency_para))
        BoxItem(modifier = Modifier.weight(0.25f), text = stringResource(R.string.sale))
        BoxItem(modifier = Modifier.weight(0.25f), text = stringResource(R.string.buy))
        SpacerItem()
    }
}