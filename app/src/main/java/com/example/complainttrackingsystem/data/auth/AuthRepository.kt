package com.example.complainttrackingsystem.data.auth

interface AuthRepository {
    suspend fun signIn(username: String, password: String): AuthResult<Unit>
    suspend fun authenticate(): AuthResult<Unit>
}