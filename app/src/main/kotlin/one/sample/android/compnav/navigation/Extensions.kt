/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/17/22, 6:44 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.navigation

import androidx.navigation.NavController
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