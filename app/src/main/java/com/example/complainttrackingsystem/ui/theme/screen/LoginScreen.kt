package com.example.complainttrackingsystem.ui.theme.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.complainttrackingsystem.R
import com.example.complainttrackingsystem.data.auth.AuthResult
import com.example.complainttrackingsystem.navigation.Screen
import com.example.complainttrackingsystem.ui.theme.UIEvents.LoginUIEvent
import com.example.complainttrackingsystem.ui.theme.components.ButtonComponent
import com.example.complainttrackingsystem.ui.theme.components.HeadingTextComponent
import com.example.complainttrackingsystem.ui.theme.components.MyTextFieldComponent
import com.example.complainttrackingsystem.ui.theme.components.NormalTextComponent
import com.example.complainttrackingsystem.ui.theme.components.PasswordTextFieldComponent
import com.example.complainttrackingsystem.ui.theme.components.UnderLinedTextComponent
import com.example.complainttrackingsystem.ui.theme.viewmodel.LoginViewModal


@Composable
fun LoginScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModal = hiltViewModel()
){
    val state = loginViewModel.state
    val context = LocalContext.current
    LaunchedEffect(loginViewModel, context) {
        loginViewModel.authResults.collect { result ->
            when(result) {
                is AuthResult.Authorized -> {
                    navController.navigate(Screen.Home.route)
                }
                is AuthResult.Unauthorized -> {
                    Toast.makeText(
                        context,
                        "You're not authorized",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is AuthResult.UnknownError -> {
                    Toast.makeText(
                        context,
                        "An unknown error occurred",
                        Toast.LENGTH_LONG
                    ).show()
                }

                else -> {}
            }
        }
    }
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            NormalTextComponent(value = stringResource(id = R.string.login))
            HeadingTextComponent(value = stringResource(id = R.string.welcome))
            Spacer(modifier = Modifier.height(20.dp))

            MyTextFieldComponent(labelValue = stringResource(id = R.string.name),
                painterResource(id = R.drawable.message),
                value = state.signInUsername,
                onTextChanged = {
                    loginViewModel.onEvent(LoginUIEvent.OnNameChanged(it))
                },
                errorStatus = loginViewModel.state.nameError
            )

            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.password),
                painterResource(id = R.drawable.lock),
                value = state.signInPassword,
                onTextSelected = {
                    loginViewModel.onEvent(LoginUIEvent.OnPasswordChanged(it))
                },
                errorStatus = loginViewModel.state.passwordError
            )

              Spacer(modifier = Modifier.height(40.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    ,horizontalArrangement = Arrangement.SpaceEvenly
            ){
                UnderLinedTextComponent(value = stringResource(id = R.string.forgot_password))

                UnderLinedTextComponent(value = stringResource(id = R.string.mpin))
            }


            Spacer(modifier = Modifier.height(80.dp))

            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 16.dp)
            ){




                ButtonComponent(
                    value = stringResource(id = R.string.login_emp),
                    navController = navController,
                    destination = Screen.Home.route,
                    onButtonClicked = {
                        loginViewModel.onEvent(LoginUIEvent.SignIn)
                    },
                    isEnabled = loginViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(20.dp))



                ButtonComponent(
                    value = stringResource(id = R.string.login_admin),
                    navController = navController,
                 destination = Screen.Home.route,
                    onButtonClicked = {
                       loginViewModel.onEvent(LoginUIEvent.SignIn)
                    },
                    isEnabled = loginViewModel.allValidationsPassed.value
                )
            }



        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfLoginScreen(){
   // LoginScreen(NavHostController())
}