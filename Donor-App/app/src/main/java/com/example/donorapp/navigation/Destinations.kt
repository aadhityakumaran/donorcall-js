package com.example.donorapp.navigation

sealed class Destinations (val route : String){

    data object HomeScreen : Destinations("homeScreen")

}