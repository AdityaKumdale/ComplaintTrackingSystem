package com.example.complainttrackingsystem.ui.theme.UIStates

data class LoginUIState(
    val isLoading: Boolean = false,
    val Username: String = "",
    val Password: String = "",

    var nameError :Boolean = false,
    var passwordError : Boolean = false
)