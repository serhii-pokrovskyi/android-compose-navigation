/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/19/22, 2:02 PM
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
import one.sample.android.compnav.navigation.AuthNavGraph
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
                navController.navigate(AuthNavGraph.MockScreen1.route)
            }) {
                Text(text = "MockScreen1")
            }
            Button(onClick = {
                navController.navigate(AuthNavGraph.FixedFlow1.route)
            }) {
                Text(text = "fixedflow1")
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