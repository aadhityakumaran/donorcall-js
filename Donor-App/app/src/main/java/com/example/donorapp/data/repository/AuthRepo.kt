package com.example.donorapp.data.repository

import com.example.donorapp.data.model.TokenResponse
import com.example.donorapp.data.model.User
import com.example.donorapp.data.model.UserLogin
import com.example.donorapp.data.model.UserSignIn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object AuthRepo{

    private val apiService = RetrofitClient.instance

    fun signUp(user: UserSignIn, onResponse: (User?) -> Unit, onFailure: (Throwable) -> Unit) {
        apiService.addUser(user).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    onResponse(response.body())
                } else {
                    onResponse(null)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                onFailure(t)
            }
        })
    }

    fun logIn(donorId: String, password: String, onSuccess: (String) -> Unit, onError: (String) -> Unit) {
        val userLogin = UserLogin(donorId, password)
        apiService.loginUser(userLogin).enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        onSuccess(it.token) // Call onSuccess with the token
                    } ?: onError("Login failed: No token received")
                } else {
                    onError("Login failed: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                onError("Network error: ${t.message}")
            }
        })
    }


}