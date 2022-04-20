/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/20/22, 3:41 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.navigation.graph

import one.sample.android.compnav.navigation.NavItem

object OperationGraph : NavItem(route = "$/operation_screens/") {
    object OperationScreen1 : NavItem(route = "${route}operation_screen_1")
    object OperationScreen2 : NavItem(route = "${route}operation_screen_2")
}