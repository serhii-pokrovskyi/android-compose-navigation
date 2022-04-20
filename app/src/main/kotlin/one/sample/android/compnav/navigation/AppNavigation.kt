/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/20/22, 3:45 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.navigation
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import one.sample.android.compnav.navigation.graph.AuthGraph
import one.sample.android.compnav.navigation.graph.GlobalGraph
import one.sample.android.compnav.navigation.graph.OperationGraph
import one.sample.android.compnav.ui.InvitationScreen
import one.sample.android.compnav.ui.LoginScreen
import one.sample.android.compnav.ui.auth.DashboardScreen
import one.sample.android.compnav.ui.auth.DashboardViewModel
import one.sample.android.compnav.ui.auth.MockScreen1
import one.sample.android.compnav.ui.auth.fixedflow.FixedFlowScreen1
import one.sample.android.compnav.ui.auth.fixedflow.FixedFlowScreen2
import one.sample.android.compnav.ui.auth.fixedflow.FixedFlowScreen3
import one.sample.android.compnav.ui.auth.operation.OperationScreen1
import one.sample.android.compnav.ui.auth.operation.OperationScreen2

@ExperimentalAnimationApi
@Composable
fun AppNavigation() {
    val navController = rememberAnimatedNavController()
    navController.addLogging()
    AnimatedNavHost(
        navController = navController,
        startDestination = GlobalGraph.Invitation.route
    ) {
        composableForward(route = GlobalGraph.Invitation.route) {
            InvitationScreen(navController)
        }
        composableForward(route = GlobalGraph.Login.route) {
            LoginScreen(navController)
        }
        authNavigation(navController)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.authNavigation(navController: NavController) =
    navigation(startDestination = AuthGraph.Dashboard.route, route = AuthGraph.route) {
        composableForward(route = AuthGraph.Dashboard.route) {
            val parentEntry = remember(it) {
                navController.getBackStackEntry(AuthGraph.Dashboard.route)
            }
            val dashboardViewModel = hiltViewModel<DashboardViewModel>(
                parentEntry
            )
            DashboardScreen(navController, dashboardViewModel)
        }
        composableForward(route = AuthGraph.MockScreen1.route) {
            MockScreen1(navController = navController)
        }
        navigation(
            startDestination = AuthGraph.FixedFlow1.FixedFlowScreen1.route,
            route = AuthGraph.FixedFlow1.route
        ) {
            composableForward(route = AuthGraph.FixedFlow1.FixedFlowScreen1.route) {
                FixedFlowScreen1(navController = navController)
            }
            composableForward(route = AuthGraph.FixedFlow1.FixedFlowScreen2.route) {
                FixedFlowScreen2(navController = navController)
            }
            composableForward(route = AuthGraph.FixedFlow1.FixedFlowScreen3.route) {
                FixedFlowScreen3(navController = navController)
            }
        }
        operationScreens(navController = navController)
    }

@ExperimentalAnimationApi
private fun NavGraphBuilder.operationScreens(navController: NavController) =
    navigation(
        startDestination = OperationGraph.OperationScreen1.route,
        route = OperationGraph.route
    ) {
        composableForward(route = OperationGraph.OperationScreen1.route) {
            OperationScreen1(navController = navController)
        }
        composableForward(route = OperationGraph.OperationScreen2.route) {
            OperationScreen2(navController = navController)
        }
    }