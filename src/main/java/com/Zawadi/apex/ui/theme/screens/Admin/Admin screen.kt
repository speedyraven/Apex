package com.Zawadi.apex.ui.theme.screens.Admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AdminPanelScreen(navController: NavController) {
    val gameList = remember { mutableStateListOf<Game>() }

    // Fetch all games from Firestore
    LaunchedEffect(Unit) {
        getAllGamesFromFirestore { games ->
            gameList.clear()
            gameList.addAll(games)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Admin Panel", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Button to add a new game
        Button(onClick = { navController.navigate("add_game") }) {
            Text("Add New Game")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // List of all games
        LazyColumn {
            items(gameList) { game ->
                GameItemView(game = game, onEdit = { navigateToEditGame(navController, game) }, onDelete = { deleteGame(game.id) })
            }
        }
    }
}

@Composable
fun GameItemView(game: Game, onEdit: () -> Unit, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(game.name, style = MaterialTheme.typography.bodyMedium)
            Text("Price: ${game.price}", style = MaterialTheme.typography.bodySmall)
            Text("Duration: ${game.duration}", style = MaterialTheme.typography.bodySmall)
            Text("Rating: ${game.rating}", style = MaterialTheme.typography.bodySmall)
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Edit Button
        IconButton(onClick = onEdit) {
            Icon(Icons.Filled.Edit, contentDescription = "Edit Game")
        }

        // Delete Button
        IconButton(onClick = onDelete) {
            Icon(Icons.Filled.Delete, contentDescription = "Delete Game")
        }
    }
}
