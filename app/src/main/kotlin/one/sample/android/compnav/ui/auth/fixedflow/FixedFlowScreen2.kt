/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/20/22, 3:45 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.ui.auth.fixedflow

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import one.sample.android.compnav.navigation.graph.AuthGraph
import one.sample.android.compnav.uikit.screen.ScreenSecondary

@Composable
fun FixedFlowScreen2(
    navController: NavController
) {
    ScreenSecondary(
        title = "FixedFlowScreen2",
        onNavClick = {
            navController.navigateUp()
        }
    ) {
        Column {
            Text(text = "FixedFlowScreen2")
            Button(onClick = {
                navController.navigate(AuthGraph.FixedFlow1.FixedFlowScreen3.route)
            }) {
                Text(text = "Next step")
            }
        }
    }
}