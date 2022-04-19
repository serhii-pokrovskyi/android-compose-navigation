/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/19/22, 1:53 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.navigation

object GlobalNavGraph {
    object Invitation : NavItem(route = "invitation")
    object Login : NavItem(route = "login")
}

object AuthNavGraph : NavItem(route = "/auth/") {
    object Dashboard : NavItem(route = "${route}dashboard")
    object MockScreen1 : NavItem(route = "${route}mockscreen1")
    object FixedFlow1 : NavItem(route = "${route}fixedflow1/") {
        object FixedFlowScreen1 : NavItem(route = "${route}fixedflowscreen1")
        object FixedFlowScreen2 : NavItem(route = "${route}fixedflowscreen2")
        object FixedFlowScreen3 : NavItem(route = "${route}fixedflowscreen3")
    }
}

object RegisterNavGraph {
    private const val PREF = "/register/"

    object RegisterPhone : NavItem(route = "${PREF}phone")
}