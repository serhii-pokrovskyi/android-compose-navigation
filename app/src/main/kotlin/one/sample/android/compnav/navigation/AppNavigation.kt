/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/18/22, 9:17 AM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import one.sample.android.compnav.ui.InvitationScreen
import one.sample.android.compnav.ui.LoginScreen
import one.sample.android.compnav.ui.auth.DashboardScreen

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
        authNavigation(navController)
    }
}

private fun NavGraphBuilder.authNavigation(navController: NavController) {
    navigation(startDestination = AuthNavGraph.Dashboard.route, route = AuthNavGraph.PREF) {
        composable(route = AuthNavGraph.Dashboard.route) {
            DashboardScreen()
        }
    }
}