package com.example.bankerror.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankerror.R
import com.example.bankerror.presentation.components.BoxItem
import com.example.bankerror.presentation.components.SpacerItem

@Preview
@Composable
fun HeadingView(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .padding(4.dp)
            .height(42.dp)
    ) {
        BoxItem(modifier = Modifier.weight(0.4f), text = stringResource(R.string.currency_para))
        BoxItem(modifier = Modifier.weight(0.3f), text = stringResource(R.string.sale))
        BoxItem(modifier = Modifier.weight(0.3f), text = stringResource(R.string.buy))
        SpacerItem(modifier.height(4.dp))
    }
}