package com.example.donorapp.data.repository

import com.example.donorapp.data.model.User

object HomeRepository {

    fun getUserDetails(): List<User> {
        return listOf(
            User(
                "John Doe",
                "password",
                "1234567890",
                "A+",
                "2021-01-01",
                "1"
            )
        )
    }

}