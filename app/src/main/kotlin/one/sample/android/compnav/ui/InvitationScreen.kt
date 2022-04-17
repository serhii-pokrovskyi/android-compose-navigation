/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/17/22, 6:21 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import one.sample.android.compnav.uikit.screen.ScreenFull

@Composable
fun InvitationScreen() {
    ScreenFull {
        Column {
            Text(text = "Invitation screen")
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Login")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Register")
            }
        }
    }
}