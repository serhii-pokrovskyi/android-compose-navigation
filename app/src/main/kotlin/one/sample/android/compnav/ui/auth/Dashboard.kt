/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/20/22, 3:45 PM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.ui.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import one.sample.android.compnav.navigation.graph.AuthGraph
import one.sample.android.compnav.navigation.graph.OperationGraph
import one.sample.android.compnav.navigation.navigateSingleTop
import one.sample.android.compnav.uikit.screen.ScreenPrimary
import timber.log.Timber
import javax.inject.Inject

@Composable
fun DashboardScreen(
    navController: NavController,
    dashboardViewModel: DashboardViewModel
) {
    ScreenPrimary(
        title = "Dashboard"
    ) {
        Column {
            Text(text = "Dashboard")
            Button(onClick = {
                navController.navigate(AuthGraph.MockScreen1.route)
            }) {
                Text(text = "MockScreen1")
            }
            Button(onClick = {
                navController.navigateSingleTop(AuthGraph.FixedFlow1.route)
            }) {
                Text(text = "fixedflow1")
            }
            Button(onClick = {
                navController.navigateSingleTop(OperationGraph.OperationScreen1.route)
            }) {
                Text(text = "Launch operation")
            }


            val textState = dashboardViewModel.testTextState.collectAsState()
            TextField(value = textState.value, onValueChange = {
                dashboardViewModel.setTestText(it)
            })
        }
    }
}

@HiltViewModel
class DashboardViewModel @Inject constructor(
    //
) : ViewModel() {

    val testTextState = MutableStateFlow("")

    fun setTestText(text: String) {
        testTextState.value = text
    }

    init {
        Timber.d("ViewModel instance = ${this.hashCode()}")
    }
}