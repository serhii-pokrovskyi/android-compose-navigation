/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/18/22, 8:36 AM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import one.sample.android.compnav.ui.InvitationScreen
import one.sample.android.compnav.ui.LoginScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = GlobalNavGraph.Invitation.route) {
        composable(route = GlobalNavGraph.Invitation.route) {
            InvitationScreen(navController)
        }
        composable(route = GlobalNavGraph.Login.route) {
            LoginScreen(navController)
        }
    }
}