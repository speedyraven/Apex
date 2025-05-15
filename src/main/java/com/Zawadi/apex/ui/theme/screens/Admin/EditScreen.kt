package com.Zawadi.apex.ui.theme.screens.Admin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.Zawadi.apex.models.Game

@Composable
fun EditGameScreen(navController: NavController, game: Game) {
    var name by remember { mutableStateOf(game.name) }
    var price by remember { mutableStateOf(game.price) }
    var duration by remember { mutableStateOf(game.duration) }
    var rating by remember { mutableStateOf(game.rating) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Edit Game", style = MaterialTheme.typography.headlineMedium)

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Game Name") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Price") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = duration,
            onValueChange = { duration = it },
            label = { Text("Duration") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = rating.toString(),
            onValueChange = { rating = it.toDoubleOrNull() ?: 0.0 },
            label = { Text("Rating") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val updatedGame = Game(game.id, name, price, duration, rating)
                editGameInFirestore(game.id, updatedGame)
                navController.popBackStack() // Navigate back to the admin panel
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Update Game")
        }
    }
}
