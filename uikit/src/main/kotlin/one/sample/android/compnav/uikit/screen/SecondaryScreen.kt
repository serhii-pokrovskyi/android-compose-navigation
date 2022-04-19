/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/18/22, 11:54 AM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.uikit.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScreenSecondary(
    title: String = "",
    navIcon: @Composable () -> Unit = {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
    },
    onNavClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = Modifier.padding(4.dp),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = title)
                },
                navigationIcon = { IconButton(onClick = onNavClick) { navIcon() } }
            )
        }
    ) {
        content()
    }
}

@Preview
@Composable
private fun ScreenSecondaryPreview() {
    ScreenSecondary(
        title = "Title"
    ) {
        Column {
            Text(text = "Content")
            Text(text = "Content")
            Text(text = "Content")
            Text(text = "Content")
        }
    }
}