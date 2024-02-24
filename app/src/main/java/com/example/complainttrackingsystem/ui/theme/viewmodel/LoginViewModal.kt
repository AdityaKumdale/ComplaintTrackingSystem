package com.example.complainttrackingsystem.ui.theme.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.complainttrackingsystem.data.auth.AuthRepository
import com.example.complainttrackingsystem.data.auth.AuthResult
import com.example.complainttrackingsystem.ui.theme.UIEvents.LoginUIEvent
import com.example.complainttrackingsystem.ui.theme.UIStates.LoginUIState
import com.example.complainttrackingsystem.util.Validator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModal @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {

    var state by mutableStateOf(LoginUIState())


    var allValidationsPassed = mutableStateOf(false)


    private val resultChannel = Channel<AuthResult<Unit>>()
    val authResults = resultChannel.receiveAsFlow()

    init {
            authenticate()
    }

    fun onEvent(event: LoginUIEvent) {
        when (event) {
            is LoginUIEvent.OnNameChanged -> {
                state = state.copy(
                    Username = event.username
                )
            }

            is LoginUIEvent.OnPasswordChanged -> {
                state = state.copy(
                    Password = event.password
                )
            }

            is LoginUIEvent.SignIn -> {
                signIn()
            }

            is LoginUIEvent.SignUp ->{
                signUp()
            }

            else -> {}
        }
        validateLoginUIDataWithRules()
    }

    private fun validateLoginUIDataWithRules() {
        val emailResult = Validator.validatename(
            name = state.Username
        )


        val passwordResult = Validator.validatePassword(
            password = state.Password
        )

        state = state.copy(
            nameError = emailResult.status,
            passwordError = passwordResult.status
        )

        allValidationsPassed.value = emailResult.status && passwordResult.status
    }

    private fun signUp() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = repository.signUp(
                username = state.Username,
                password = state.Password
            )
            resultChannel.send(result)
            state = state.copy(isLoading = false)
        }
    }

    private fun signIn() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = repository.signIn(
                username = state.Username,
                password = state.Password
            )
            resultChannel.send(result)
            state = state.copy(isLoading = false)
        }
    }
    private fun authenticate() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = repository.authenticate()
            resultChannel.send(result)
            state = state.copy(isLoading = false)
        }
    }

}