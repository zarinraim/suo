package com.zarinraim.accounting.scene.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun ItemDisplay(
    leadingText: String,
    mainText: String,
    featureText: String,
    backgroundColor: Color,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(all = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = leadingText)
        HorizontalSpacer()

        Text(
            text = mainText,
            overflow = TextOverflow.Visible,
            modifier = Modifier.weight(1f)
        )

        HorizontalSpacer()
        Text(text = featureText)
    }
}