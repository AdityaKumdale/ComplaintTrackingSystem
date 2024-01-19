package com.example.complainttrackingsystem.ui.theme.UIStates

data class LoginUIState(
    val isLoading: Boolean = false,
    val signInUsername: String = "",
    val signInPassword: String = "",

    var nameError :Boolean = false,
    var passwordError : Boolean = false
)