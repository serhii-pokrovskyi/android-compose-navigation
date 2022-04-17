/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/17/22, 6:22 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.uikit.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Represents full screen layout without top bar
 */
@Composable
fun ScreenFull(
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = Modifier.padding(4.dp)
    ) {
        content()
    }
}

@Preview
@Composable
private fun ScreenFullPreview() {
    ScreenFull {
        Column {
            Text(text = "Some content")
        }
    }
}