/*
 * Developed by Serhii Pokrovskyi
 * e-mail: serg.pokrovskyi@gmail.com
 * Last modified: 4/18/22, 9:35 AM
 * Copyright (c) 2022
 */

package one.sample.android.compnav.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import one.sample.android.compnav.navigation.AuthNavGraph
import one.sample.android.compnav.uikit.screen.ScreenFull
import javax.inject.Inject

@Composable
fun LoginScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val viewModel = hiltViewModel<LoginViewModel>()

    val loginState = viewModel.loginState.collectAsState()
    val userName = viewModel.userName.collectAsState()
    val password = viewModel.password.collectAsState()

    LaunchedEffect(key1 = loginState.value) {
        loginState.value?.let {
            if (it.isSuccess) {
                navController.navigate(AuthNavGraph.PREF)
            } else {
                Toast.makeText(context, "Login failed", Toast.LENGTH_LONG).show()
            }
        }
    }

    ScreenFull {
        Column {
            Text(text = "Login: user; password: 123")
            TextField(value = userName.value, onValueChange = {
                viewModel.setUserName(it)
            })
            TextField(value = password.value, onValueChange = {
                viewModel.setPassword(it)
            })

            Button(onClick = {
                viewModel.login()
            }) {
                Text(text = "Login")
            }
        }
    }
}

@HiltViewModel
class LoginViewModel @Inject constructor(
    //
) : ViewModel() {
    val userName = MutableStateFlow("")
    val password = MutableStateFlow("")
    val loginState = MutableStateFlow<LoginState?>(null)

    fun setUserName(userName: String) {
        this.userName.value = userName
    }

    fun setPassword(password: String) {
        this.password.value = password
    }

    fun login() {
        if ((userName.value == "user") and (password.value == "123")) {
            loginState.value = LoginState(true)
        } else {
            loginState.value = LoginState(false)
        }
    }

    class LoginState(
        val isSuccess: Boolean
    )
}