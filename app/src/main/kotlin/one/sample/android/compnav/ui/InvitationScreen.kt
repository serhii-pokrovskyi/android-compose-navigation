/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/20/22, 3:45 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import one.sample.android.compnav.navigation.graph.GlobalGraph
import one.sample.android.compnav.uikit.screen.ScreenFull

@Composable
fun InvitationScreen(
    navController: NavController
) {
    val context = LocalContext.current
    ScreenFull {
        Column {
            Text(text = "Invitation screen")
            Button(onClick = {
                navController.navigate(GlobalGraph.Login.route)
            }) {
                Text(text = "Login")
            }
            Button(onClick = {
                Toast.makeText(context, "Not implemented", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Register")
            }
        }
    }
}