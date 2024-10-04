package com.example.donorapp.navigation

sealed class Destinations (val route : String){

    data object HomeScreen : Destinations("homeScreen")
    data object SignUpScreen : Destinations("signUpScreen")
    data object LoginScreen : Destinations("loginScreen")

}