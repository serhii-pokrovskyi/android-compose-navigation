/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/20/22, 12:51 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.*
import com.google.accompanist.navigation.animation.composable
import timber.log.Timber

/**
 * Ads logging to nav controller
 */
fun NavController.addLogging() {
    addOnDestinationChangedListener { controller, destination, arguments ->
        val navMsg = destination.route
        if (navMsg == null) {
            Timber.e("Navigating to unknown, this is strange!")
        } else {
            Timber.i("Navigating to $navMsg")
        }
    }
}

fun NavController.navigateSingleTop(route: String) {
    this.navigate(route = route) {
        launchSingleTop = true
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.composableForward(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    enterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition?)? = {
        slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(700))
    },
    exitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition?)? = {
        slideOutOfContainer(
            AnimatedContentScope.SlideDirection.Left,
            animationSpec = tween(700)
        )
    },
    popEnterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition?)? = {
        slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(700))
    },
    popExitTransition: (
    AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition?
    )? = {
        slideOutOfContainer(
            AnimatedContentScope.SlideDirection.Right,
            animationSpec = tween(700)
        )
    },
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) = composable(
    route,
    arguments,
    deepLinks,
    enterTransition,
    exitTransition,
    popEnterTransition,
    popExitTransition,
    content
)
