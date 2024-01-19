package com.example.complainttrackingsystem.data.auth

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApi {

    @POST("signin")   //dummy requests
    suspend fun signIn(
        @Body request: AuthRequest
    ): TokenResponse

    @GET("authenticate")    //dummy requests
    suspend fun authenticate(
        @Header("Authorization") token: String      //dummy requests
    )
}