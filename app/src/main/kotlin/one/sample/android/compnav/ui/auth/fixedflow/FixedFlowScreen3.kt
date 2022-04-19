/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/19/22, 1:06 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.ui.auth.fixedflow

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import one.sample.android.compnav.navigation.AuthNavGraph
import one.sample.android.compnav.uikit.screen.ScreenSecondary

@Composable
fun FixedFlowScreen3(
    navController: NavController
) {
    ScreenSecondary(
        title = "FixedFlowScreen3",
        onNavClick = {
            navController.navigateUp()
        }
    ) {
        Column {
            Text(text = "Finish")
            Text(text = "FixedFlowScreen3")
            Button(onClick = {
                //navController.popBackStack()
                navController.popBackStack(route = AuthNavGraph.Dashboard.route, inclusive = false)
            }) {
                Text(text = "to dashboard")
            }
        }
    }
}