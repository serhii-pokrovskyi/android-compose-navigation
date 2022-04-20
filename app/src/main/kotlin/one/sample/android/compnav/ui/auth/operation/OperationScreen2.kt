/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/20/22, 3:45 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.ui.auth.operation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import one.sample.android.compnav.navigation.graph.AuthGraph
import one.sample.android.compnav.navigation.graph.OperationGraph
import one.sample.android.compnav.navigation.navigateSingleTop
import one.sample.android.compnav.uikit.screen.ScreenSecondary

@Composable
fun OperationScreen2(
    navController: NavController
) {
    ScreenSecondary(
        onNavClick = {
            navController.navigateUp()
        }
    ) {
        Column {
            Text(text = "OperationScreen2")
            Button(onClick = {
                navController.navigateUp()
            }) {
                Text(text = "back")
            }
            Button(onClick = {
                navController.navigateSingleTop(OperationGraph.OperationScreen1.route)
            }) {
                Text(text = "to screen1")
            }
            Button(onClick = {
                navController.popBackStack(route = AuthGraph.Dashboard.route, inclusive = false)
            }) {
                Text(text = "to dashboard")
            }
        }
    }
}