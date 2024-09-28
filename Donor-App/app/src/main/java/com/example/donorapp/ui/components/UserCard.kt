package com.example.donorapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun UserCard(
    id : String,
    phone : String,
    donorId : String,
    bloodGroup : String,
    lastDonationDate : String,
    modifier: Modifier = Modifier,
){

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp, start = 8.dp, end = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    )
    {
        Column(modifier = modifier.padding(16.dp).fillMaxWidth()) {
            Text(text = id, fontWeight = FontWeight.Bold)
            Text(text = phone, fontWeight = FontWeight.Bold)
            Text(text = donorId, fontWeight = FontWeight.Bold)
            Text(text = bloodGroup, fontWeight = FontWeight.Bold)
            Text(text = lastDonationDate, fontWeight = FontWeight.Bold)

        }
    }
}