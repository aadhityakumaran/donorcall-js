package com.example.donorapp.ui.view

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.donorapp.ui.components.InputTextField
import com.example.donorapp.viewmodel.LoginViewModel

@Composable
fun SignUpVIew(
    navController: NavController,
    viewmodel: LoginViewModel = viewModel()
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputTextField(
                label = "Name",
                value = viewmodel.name,
                onValueChanged = {
                    viewmodel.name = it
                }
            )

            InputTextField(
                label = "Password",
                value = viewmodel.password,
                onValueChanged = {
                    viewmodel.password = it
                }
            )

            InputTextField(
                label = "Phone",
                value = viewmodel.phone,
                onValueChanged = {
                    viewmodel.phone = it
                }
            )

            InputTextField(
                label = "Blood Group",
                value = viewmodel.bloodGroup,
                onValueChanged = {
                    viewmodel.bloodGroup = it
                }
            )

            Button(
                onClick = {
                    viewmodel.signIn(

                    )
                }
            ) {
                Text("Sign In")
            }
        }
    }
}
