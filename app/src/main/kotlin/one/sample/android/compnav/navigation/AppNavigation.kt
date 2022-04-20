/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/20/22, 12:56 PM
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
        startDestination = GlobalNavGraph.Invitation.route
    ) {
        composableForward(route = GlobalNavGraph.Invitation.route) {
            InvitationScreen(navController)
        }
        composableForward(route = GlobalNavGraph.Login.route) {
            LoginScreen(navController)
        }
        authNavigation(navController)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.authNavigation(navController: NavController) =
    navigation(startDestination = AuthNavGraph.Dashboard.route, route = AuthNavGraph.route) {
        composableForward(route = AuthNavGraph.Dashboard.route) {
            val parentEntry = remember(it) {
                navController.getBackStackEntry(AuthNavGraph.Dashboard.route)
            }
            val dashboardViewModel = hiltViewModel<DashboardViewModel>(
                parentEntry
            )
            DashboardScreen(navController, dashboardViewModel)
        }
        composableForward(route = AuthNavGraph.MockScreen1.route) {
            MockScreen1(navController = navController)
        }
        navigation(
            startDestination = AuthNavGraph.FixedFlow1.FixedFlowScreen1.route,
            route = AuthNavGraph.FixedFlow1.route
        ) {
            composableForward(route = AuthNavGraph.FixedFlow1.FixedFlowScreen1.route) {
                FixedFlowScreen1(navController = navController)
            }
            composableForward(route = AuthNavGraph.FixedFlow1.FixedFlowScreen2.route) {
                FixedFlowScreen2(navController = navController)
            }
            composableForward(route = AuthNavGraph.FixedFlow1.FixedFlowScreen3.route) {
                FixedFlowScreen3(navController = navController)
            }
        }
        operationScreens(navController = navController)
    }

@ExperimentalAnimationApi
private fun NavGraphBuilder.operationScreens(navController: NavController) =
    navigation(
        startDestination = AuthNavGraph.OperationScreens.OperationScreen1.route,
        route = AuthNavGraph.OperationScreens.route
    ) {
        composableForward(route = AuthNavGraph.OperationScreens.OperationScreen1.route) {
            OperationScreen1(navController = navController)
        }
        composableForward(route = AuthNavGraph.OperationScreens.OperationScreen2.route) {
            OperationScreen2(navController = navController)
        }
    }