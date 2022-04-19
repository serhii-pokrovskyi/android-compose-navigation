/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/19/22, 1:49 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.ui.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
            Button(onClick = {
                navController.navigate(AuthNavGraph.FixedFlow1.route)
            }) {
                Text(text = "fixedflow1")
            }


            val textState = remember {
                mutableStateOf("")
            }
            TextField(value = textState.value, onValueChange = {
                textState.value = it
            })
        }
    }
}