package com.Zawadi.apex.ui.theme.screens.Admin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import com.Zawadi.apex.R
import com.Zawadi.apex.data.AuthViewGames

import com.Zawadi.apex.models.Games
import com.Zawadi.apex.navigation.Routes.ROUT_ADDGAME
import com.google.firebase.auth.FirebaseAuth

@Composable
fun GamesViewScreen(navController: NavHostController) {
    val context = LocalContext.current
    val authViewGames = remember { AuthViewGames(navController, context) }

    val gameList = remember { mutableStateListOf<Games>() }

    val currentUser = FirebaseAuth.getInstance().currentUser
    val currentUserId = currentUser?.uid

    // Fetch games only once when the composable first loads
    LaunchedEffect(Unit) {
        authViewGames.allGames(gameList)
    }

    val userGames = gameList.filter { it.userId == currentUserId }
    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.assassin),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Spacer(modifier = Modifier.height(40.dp))

            TextButton(onClick = { navController.navigate(ROUT_ADDGAME) }) {
                Text(text = "Add New Games")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Games Listings",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            if (userGames.isEmpty()) {
                Text("No games found for your account.")
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(userGames) { game ->
                        GameItem(
                            game = game,
                            onUpdate = {
                                navController.navigate("edit_games_screen/${game.id}")
                            },
                            onDelete = {
                                authViewGames.deleteGame(game.id)
                            }
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun GameItem(
    game: Games,
    onUpdate: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${game.name}", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = "Duration: ${game.duration}", fontSize = 14.sp)
            Text(text = "Price: ${game.price}", fontSize = 14.sp)
            Text(text = "Rating: ${game.rating}", fontSize = 14.sp)

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedButton(onClick = onUpdate) {
                    Icon(Icons.Default.Edit, contentDescription = "Update")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Update")
                }
                Button(onClick = onDelete, colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Delete", color = Color.White)
                }
            }
        }
    }
}
