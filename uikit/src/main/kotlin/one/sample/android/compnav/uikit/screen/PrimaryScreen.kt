/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/18/22, 9:12 AM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.uikit.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScreenPrimary(
    title: String = "",
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = Modifier.padding(4.dp),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = title)
                }
            )
        }
    ) {
        content()
    }
}

@Preview
@Composable
private fun ScreenPrimaryPreview() {
    ScreenPrimary(
        title = "Title"
    ) {
        Column {
            Text(text = "content")
            Text(text = "content")
            Text(text = "content")
            Text(text = "content")
        }
    }
}