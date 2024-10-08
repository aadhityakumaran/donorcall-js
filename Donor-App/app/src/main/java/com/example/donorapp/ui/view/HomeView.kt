package com.example.donorapp.ui.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.donorapp.ui.components.AppBar
import com.example.donorapp.ui.components.UserCard
import com.example.donorapp.ui.modifiers.shimmerEffect
import com.example.donorapp.viewmodel.HomeViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.donorapp.ui.theme.appSecondary


@Composable
fun HomeView(
    navController: NavController,
    viewModel: HomeViewModel = viewModel()
){

    Scaffold(
        topBar = {
            AppBar(
                "Home"
            )
        },
        containerColor = appSecondary
    )
    {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            if (viewModel.isLoading){
                item(1) {
                    UserCard(
                        "",
                        "",
                        "",
                        "",
                        "",
                        modifier = Modifier.shimmerEffect(true)
                    )
                }
            } else {
                val users = viewModel.userDetails
                items(users.size) { index ->
                    UserCard(
                        users[index].name,
                        users[index].phone,
                        users[index].donorId,
                        users[index].bloodGroup,
                        users[index].lastDonationDate
                    )
                }
            }
        }
    }
}
