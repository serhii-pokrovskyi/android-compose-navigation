/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/20/22, 12:56 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.navigation

object GlobalNavGraph : NavItem(route = "/") {
    object Invitation : NavItem(route = "${route}invitation")
    object Login : NavItem(route = "${route}login")
}

object AuthNavGraph : NavItem(route = "/auth/") {
    object Dashboard : NavItem(route = "${route}dashboard")
    object MockScreen1 : NavItem(route = "${route}mockscreen1")
    object FixedFlow1 : NavItem(route = "${route}fixedflow1/") {
        object FixedFlowScreen1 : NavItem(route = "${route}fixedflowscreen1")
        object FixedFlowScreen2 : NavItem(route = "${route}fixedflowscreen2")
        object FixedFlowScreen3 : NavItem(route = "${route}fixedflowscreen3")
    }

    object OperationScreens : NavItem(route = "${route}operation_screens") {
        object OperationScreen1 : NavItem(route = "${route}operation_screen_1")
        object OperationScreen2 : NavItem(route = "${route}operation_screen_2")
    }
}

object RegisterNavGraph : NavItem(route = "/register/") {
    object RegisterPhone : NavItem(route = "${route}phone")
}