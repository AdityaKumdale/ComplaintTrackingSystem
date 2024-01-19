package com.example.complainttrackingsystem.util

object Validator {
    fun validatename(name: String): ValidationResult {
        return ValidationResult(
            (name.isNotEmpty())
        )
    }

    fun validatePassword(password: String): ValidationResult {
        return ValidationResult(
            (password.isNotEmpty() && password.length >= 4)
        )
    }
}

data class ValidationResult(
    val status: Boolean = false
)