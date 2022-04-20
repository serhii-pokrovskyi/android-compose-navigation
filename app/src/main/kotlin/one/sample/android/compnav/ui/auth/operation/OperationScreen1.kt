/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/20/22, 12:51 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.ui.auth.operation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import one.sample.android.compnav.navigation.AuthNavGraph
import one.sample.android.compnav.navigation.navigateSingleTop
import one.sample.android.compnav.uikit.screen.ScreenSecondary

@Composable
fun OperationScreen1(
    navController: NavController
) {
    ScreenSecondary(
        onNavClick = {
            navController.navigateUp()
        }
    ) {
        Column {
            Text(text = "OperationScreen1")
            Button(onClick = {
                navController.navigateUp()
            }) {
                Text(text = "back")
            }
            Button(onClick = {
                navController.navigateSingleTop(AuthNavGraph.OperationScreens.OperationScreen2.route)
            }) {
                Text(text = "to screen2")
            }
            Button(onClick = {
                navController.popBackStack(route = AuthNavGraph.Dashboard.route, inclusive = false)
            }) {
                Text(text = "to dashboard")
            }
        }
    }
}