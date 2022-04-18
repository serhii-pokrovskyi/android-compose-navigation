/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/18/22, 3:16 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.ui.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import one.sample.android.compnav.uikit.screen.ScreenSecondary

@Composable
fun MockScreen1(
    navController: NavController
) {
    ScreenSecondary(
        title = "MockScreen1",
        onNavClick = {
            navController.navigateUp()
        }
    ) {
        Column {
            Text(text = "MockScreen1")
        }
    }
}