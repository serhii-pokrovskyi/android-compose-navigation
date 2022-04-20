/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/20/22, 3:45 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.navigation.graph

import one.sample.android.compnav.navigation.NavItem

object GlobalGraph : NavItem(route = "/") {
    object Invitation : NavItem(route = "${route}invitation")
    object Login : NavItem(route = "${route}login")
}