/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/17/22, 6:39 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import one.sample.android.compnav.ui.InvitationScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = GlobalNavGraph.Invitation.route) {
        composable(route = GlobalNavGraph.Invitation.route) {
            InvitationScreen()
        }
    }
}