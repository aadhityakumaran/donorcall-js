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
fun LoginView(
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
                label = "Donor ID",
                value = viewmodel.donorId,
                onValueChanged = {
                    viewmodel.donorId = it
                }
            )

            InputTextField(
                label = "Password",
                value = viewmodel.password,
                onValueChanged = {
                    viewmodel.password = it
                }
            )

            Button(
                onClick = {
                    viewmodel.logIn(
                        onSuccess = {
                            Log.d("LoginView", "Login successful")
                            navController.navigate("homeScreen")
                            viewmodel.donorId = ""
                            viewmodel.password = ""
                        },
                        onError = { errorMessage ->
                            Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            ) {
                Text("Login")
            }

            Button(
                modifier = Modifier.padding(16.dp),
                onClick = {
                    navController.navigate("signUpScreen")
                }) {
                Text(text = "Create Account")
            }
        }


    }
}
