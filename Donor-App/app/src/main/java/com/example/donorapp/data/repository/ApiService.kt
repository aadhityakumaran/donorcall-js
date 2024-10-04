package com.example.donorapp.data.repository

import com.example.donorapp.data.model.TokenResponse
import com.example.donorapp.data.model.User
import com.example.donorapp.data.model.UserLogin
import com.example.donorapp.data.model.UserSignIn
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {

    @POST("signup")
    fun addUser(user: UserSignIn): Call<User>

    @POST("login")
    fun loginUser(@Body userLogin: UserLogin): Call<TokenResponse>

}