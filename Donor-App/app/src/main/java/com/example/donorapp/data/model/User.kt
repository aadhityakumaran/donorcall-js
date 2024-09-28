package com.example.donorapp.data.model

data class User(
    val name : String,
    val phoneNumber : String,
    val donorId : String,
    val bloodGroup : String,
    val lastDonationDate : String
)

object userList {
    val user1 = listOf(
        User("Jin Sakai", "What is phone?", "Ghost", "HONOR", "Before DYing")
    )
}
