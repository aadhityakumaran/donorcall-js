package com.example.donorapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.donorapp.data.model.UserSignIn
import com.example.donorapp.data.repository.AuthRepo

class LoginViewModel : ViewModel() {

    var name by mutableStateOf("")
    var password by mutableStateOf("")
    var phone by mutableStateOf("")
    var bloodGroup by mutableStateOf("")
    var donorId by mutableStateOf("")



    fun logIn(onSuccess: (String) -> Unit, onError: (String) -> Unit) {
        AuthRepo.logIn(donorId, password, onSuccess, onError)
    }


    fun signIn() {
        AuthRepo.signUp(
            UserSignIn(
                name = name,
                password = password,
                phone = phone,
                bloodGroup = bloodGroup
            ),
            onResponse = { token ->
                if (token != null) {
                    // Store the token securely (e.g., SharedPreferences)
                    // Navigate to the next screen or update UI
                } else {
                    // Handle failure (e.g., show an error message)
                }
            },
            onFailure = { throwable ->
                // Handle network error
            }
        )
    }

}