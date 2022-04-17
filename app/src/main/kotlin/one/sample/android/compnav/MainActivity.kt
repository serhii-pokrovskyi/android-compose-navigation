/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/17/22, 6:22 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import one.sample.android.compnav.ui.InvitationScreen
import one.sample.android.compnav.uikit.theme.AndroidComposeNavigationTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeNavigationTheme {
                InvitationScreen()
            }
        }
    }
}