package com.example.donorapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.donorapp.ui.view.HomeView

@Composable
fun NavGraph (
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Destinations.HomeScreen.route){
        composable(Destinations.HomeScreen.route){
            HomeView(navController = navController)
        }
    }
}
