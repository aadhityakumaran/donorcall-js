package com.example.donorapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.donorapp.ui.theme.appPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
) {
    TopAppBar(
        title = {
            Row {
                Text(
                    text = title,
                    modifier = Modifier.padding(start = 4.dp),
                    color = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = appPrimary),
    )
}