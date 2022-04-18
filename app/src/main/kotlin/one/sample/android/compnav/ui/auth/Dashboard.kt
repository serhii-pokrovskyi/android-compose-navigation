/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/18/22, 3:15 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.ui.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import one.sample.android.compnav.navigation.AuthNavGraph
import one.sample.android.compnav.uikit.screen.ScreenPrimary

@Composable
fun DashboardScreen(
    navController: NavController
) {
    ScreenPrimary(
        title = "Dashboard"
    ) {
        Column {
            Text(text = "Dashboard")
            Button(onClick = {
                navController.navigate(AuthNavGraph.MockScreen1.route)
            }) {
                Text(text = "MockScreen1")
            }
        }
    }
}