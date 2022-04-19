/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/19/22, 12:51 PM
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
import one.sample.android.compnav.ui.auth.MockScreen1
import one.sample.android.compnav.ui.auth.fixedflow.FixedFlowScreen1
import one.sample.android.compnav.ui.auth.fixedflow.FixedFlowScreen2
import one.sample.android.compnav.ui.auth.fixedflow.FixedFlowScreen3

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    navController.addLogging()
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

private fun NavGraphBuilder.authNavigation(navController: NavController) =
    navigation(startDestination = AuthNavGraph.Dashboard.route, route = AuthNavGraph.route) {
        composable(route = AuthNavGraph.Dashboard.route) {
            DashboardScreen(navController)
        }
        composable(route = AuthNavGraph.MockScreen1.route) {
            MockScreen1(navController = navController)
        }
        navigation(
            startDestination = AuthNavGraph.FixedFlow1.FixedFlowScreen1.route,
            route = AuthNavGraph.FixedFlow1.route
        ) {
            composable(route = AuthNavGraph.FixedFlow1.FixedFlowScreen1.route) {
                FixedFlowScreen1(navController = navController)
            }
            composable(route = AuthNavGraph.FixedFlow1.FixedFlowScreen2.route) {
                FixedFlowScreen2(navController = navController)
            }
            composable(route = AuthNavGraph.FixedFlow1.FixedFlowScreen3.route) {
                FixedFlowScreen3(navController = navController)
            }
        }
    }