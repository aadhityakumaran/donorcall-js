package com.example.donorapp.data.model

data class User(
    val name : String,
    val password : String,
    val phone : String,
    val bloodGroup : String,
    val lastDonationDate : String,
    val donorId : String
)

data class UserSignIn(
    val name : String,
    val password : String,
    val phone : String,
    val bloodGroup : String
)

data class UserLogin(
    val donorId: String,
    val password: String
)

data class TokenResponse(
    val token: String
)