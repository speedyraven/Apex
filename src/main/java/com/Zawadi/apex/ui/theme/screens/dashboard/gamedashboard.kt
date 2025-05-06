package com.Zawadi.apex.ui.theme.screens.dashboard



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage



@Composable
fun FullDashboard() {
    Row(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        SidebarNavigation()
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f).verticalScroll(rememberScrollState())) {
            TopBar()
            Spacer(modifier = Modifier.height(16.dp))
            GameHighlightCard()
            Spacer(modifier = Modifier.height(16.dp))
            ProductCard()
            Spacer(modifier = Modifier.height(16.dp))
            Text("Recently Played", color = Color.White, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            RecentlyPlayed()
        }
        Spacer(modifier = Modifier.width(8.dp))
        RightSidebar()
    }
}

@Composable
fun SidebarNavigation() {
    Column(
        modifier = Modifier.width(56.dp).fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFF00C896), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("L", color = Color.White)
            }
            Icon(Icons.Default.Home, contentDescription = null, tint = Color.White)
            Icon(Icons.Default.Group, contentDescription = null, tint = Color.White)
            Icon(Icons.Default.Chat, contentDescription = null, tint = Color(0xFF00C896))
            Icon(Icons.Default.ShoppingCart, contentDescription = null, tint = Color.White)
            Icon(Icons.Default.Star, contentDescription = null, tint = Color.White)
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search anything...") },
            modifier = Modifier.weight(1f).height(48.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.DarkGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = Color.White
            )
        )
        Spacer(modifier = Modifier.width(12.dp))
        Icon(Icons.Default.Notifications, contentDescription = null, tint = Color.White)
        Spacer(modifier = Modifier.width(12.dp))
        Icon(Icons.Default.Send, contentDescription = null, tint = Color.White)
        Spacer(modifier = Modifier.width(12.dp))
        Icon(Icons.Default.Person, contentDescription = null, tint = Color.White)
    }
}

@Composable
fun GameHighlightCard() {
    Card(
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.DarkGray,
        modifier = Modifier.fillMaxWidth().height(200.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = "https://upload.wikimedia.org/wikipedia/en/7/71/Assassin%27s_Creed_Valhalla_cover_art.jpg",
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Assassin’s Creed Valhalla", fontSize = 20.sp, color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("29$", color = Color.White, fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = {}, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF00C896))) {
                        Text("Add to cart")
                    }
                }
            }
        }
    }
}

@Composable
fun ProductCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color(0xFF2A2A2A),
        modifier = Modifier.fillMaxWidth().height(150.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = "https://images.unsplash.com/photo-1606813903263-39d1bd51c1a0",
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text("Best Gaming Headset", color = Color.White)
            }
        }
    }
}

@Composable
fun RecentlyPlayed() {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        items(3) {
            Card(
                modifier = Modifier.size(200.dp, 100.dp),
                shape = RoundedCornerShape(12.dp),
                backgroundColor = Color.Gray
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    AsyncImage(
                        model = "https://picsum.photos/seed/game$it/200/100",
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Text("Game $it", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun RightSidebar() {
    Column(
        modifier = Modifier.width(160.dp).fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("Library", color = Color.White, fontSize = 16.sp)
            repeat(3) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Minecraft", color = Color.White, fontSize = 14.sp)
                    Icon(Icons.Default.Download, contentDescription = null, tint = Color.White)
                }
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("Mail", color = Color.White, fontSize = 16.sp)
            Text("Nothing to show Right now", color = Color.Gray, fontSize = 12.sp)
        }
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Online Friends", color = Color.White, fontSize = 16.sp)
            Text("Goodboi79 - Rocket league", color = Color.Gray, fontSize = 12.sp)
            Text("Doglover96 - Counter Strike", color = Color.Gray, fontSize = 12.sp)
            Text("iamgoat__ - Goat simulator", color = Color.Gray, fontSize = 12.sp)
        }
    }
}
@Composable
@Preview(showBackground = true)
fun PreviewFullDashboard() {

        FullDashboard()
    }

