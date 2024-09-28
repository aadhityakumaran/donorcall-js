package com.example.donorapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.donorapp.data.model.User
import com.example.donorapp.data.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    var isLoading by mutableStateOf(true)

    private val _userDetails = mutableStateOf(listOf<User>())
    val userDetails: List<User> by _userDetails

    init {
        fetchParticipants()
    }

    private fun fetchParticipants() {
        viewModelScope.launch {
            isLoading = true
            val users = HomeRepository.getUserDetails()
            _userDetails.value = users
            isLoading = false
        }
    }

}