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
                    signInUsername = event.username
                )
            }

            is LoginUIEvent.OnPasswordChanged -> {
                state = state.copy(
                    signInPassword = event.password
                )
            }

            is LoginUIEvent.SignIn -> {
                signIn()
            }

            else -> {}
        }
        validateLoginUIDataWithRules()
    }

    private fun validateLoginUIDataWithRules() {
        val emailResult = Validator.validatename(
            name = state.signInUsername
        )


        val passwordResult = Validator.validatePassword(
            password = state.signInPassword
        )

        state = state.copy(
            nameError = emailResult.status,
            passwordError = passwordResult.status
        )

        allValidationsPassed.value = emailResult.status && passwordResult.status
    }


    private fun signIn() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = repository.signIn(
                username = state.signInUsername,
                password = state.signInPassword
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