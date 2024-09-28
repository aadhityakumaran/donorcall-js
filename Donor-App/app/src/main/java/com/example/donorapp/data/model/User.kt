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
        User("John Doe", "1234567890", "1234", "A+", "12/12/2020")
    )
}
