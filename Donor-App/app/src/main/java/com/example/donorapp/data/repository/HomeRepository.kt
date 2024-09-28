package com.example.donorapp.data.repository

import com.example.donorapp.data.model.User
import com.example.donorapp.data.model.userList

object HomeRepository {

    fun getUserDetails(): List<User> {
        return userList.user1
    }

}