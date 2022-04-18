/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/18/22, 9:13 AM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.ui.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import one.sample.android.compnav.uikit.screen.ScreenPrimary

@Composable
fun DashboardScreen() {
    ScreenPrimary(
        title = "Dashboard"
    ) {
        Column {
            Text(text = "Dashboard")
        }
    }
}