package com.example.donorapp.ui.components

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
    name : String,
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
        colors = CardDefaults.cardColors(containerColor = Color.Blue)
    )
    {
        Column(modifier = modifier.padding(16.dp).fillMaxWidth()) {
            Text(text = "Name\n$name", fontWeight = FontWeight.Bold)
            Text(text = "Phone Number\n$phone", fontWeight = FontWeight.Bold)
            Text(text = "Donor ID\n$donorId", fontWeight = FontWeight.Bold)
            Text(text = "Blood Group\n$bloodGroup", fontWeight = FontWeight.Bold)
            Text(text = "Last Donated\n$lastDonationDate", fontWeight = FontWeight.Bold)

        }
    }
}