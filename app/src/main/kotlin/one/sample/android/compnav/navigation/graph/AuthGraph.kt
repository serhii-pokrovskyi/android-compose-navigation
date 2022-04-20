/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/20/22, 3:45 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.navigation.graph

import one.sample.android.compnav.navigation.NavItem

object AuthGraph : NavItem(route = "/auth/") {
    object Dashboard : NavItem(route = "${route}dashboard")
    object MockScreen1 : NavItem(route = "${route}mockscreen1")
    object FixedFlow1 : NavItem(route = "${route}fixedflow1/") {
        object FixedFlowScreen1 : NavItem(route = "${route}fixedflowscreen1")
        object FixedFlowScreen2 : NavItem(route = "${route}fixedflowscreen2")
        object FixedFlowScreen3 : NavItem(route = "${route}fixedflowscreen3")
    }
}