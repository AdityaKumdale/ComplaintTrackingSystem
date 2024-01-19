package com.example.complainttrackingsystem.ui.theme.UIEvents

sealed class LoginUIEvent {

        data class OnNameChanged(val username:String): LoginUIEvent()
        data class OnPasswordChanged(val password: String) : LoginUIEvent()

        object SignIn: LoginUIEvent()
}