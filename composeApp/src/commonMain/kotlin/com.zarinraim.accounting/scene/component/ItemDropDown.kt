package com.zarinraim.accounting.scene.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun ItemDropDownPrimary(
    number: String,
    title: String,
    expanded: Boolean,
    backgroundColor: Color = Color.Unspecified,
    onClick: () -> Unit,
) {
    CompositionLocalProvider(
        LocalTextStyle provides LocalTextStyle.current.copy(fontWeight = FontWeight.Bold)
    ) {
        Surface(elevation = 2.dp, modifier = Modifier.zIndex(100f)) {
            Content(
                leadingText = number,
                mainText = title,
                expanded = expanded,
                modifier = Modifier.background(backgroundColor),
                onClick = onClick
            )
        }
    }
}

@Composable
fun ItemDropDownSecondary(
    number: String,
    title: String,
    expanded: Boolean,
    backgroundColor: Color = Color.Unspecified,
    onClick: () -> Unit,
) {
    CompositionLocalProvider {
        Surface(elevation = 1.dp) {
            Content(
                leadingText = number,
                mainText = title,
                expanded = expanded,
                modifier = Modifier.background(backgroundColor),
                onClick = onClick
            )
        }
    }
}

@Composable
private fun Content(
    leadingText: String,
    mainText: String,
    expanded: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
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
        when {
            expanded -> Icon(Icons.Default.KeyboardArrowUp, "")
            else -> Icon(Icons.Default.KeyboardArrowDown, "")
        }
    }
}