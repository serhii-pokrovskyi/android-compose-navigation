/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/18/22, 9:17 AM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.navigation

object GlobalNavGraph {
    object Invitation : NavItem(route = "invitation")
    object Login : NavItem(route = "login")
}

object AuthNavGraph {
    const val PREF = "/auth/"

    object Dashboard : NavItem(route = "${PREF}dashboard")
}

object RegisterNavGraph {
    private const val PREF = "/register/"

    object RegisterPhone : NavItem(route = "${PREF}phone")
}