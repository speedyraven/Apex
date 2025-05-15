package com.Zawadi.apex.ui.theme.screens.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.Zawadi.apex.R
import com.Zawadi.apex.navigation.ROUT_GAMES
import com.Zawadi.apex.navigation.ROUT_HOME
import com.Zawadi.apex.navigation.ROUT_MESSAGES
import com.Zawadi.apex.navigation.ROUT_PROFILE
import com.Zawadi.apex.navigation.ROUT_SETTINGS

@Composable
        fun HomeScreen(navController: NavHostController) {
            // Main content layout
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Profile Section
                ProfileSection()

                Spacer(modifier = Modifier.height(20.dp))

                // Greeting Section
                GreetingSection()

                Spacer(modifier = Modifier.height(20.dp))

                // Navigation Buttons Section
                NavigationButtons(navController)

                Spacer(modifier = Modifier.height(40.dp))

                // Bottom Navigation
                BottomNavigationBar(navController)
            }
        }

        @Composable
        fun ProfileSection() {
            // Profile Image
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.letterlogo), // Replace with actual profile image
                    contentDescription = "Profile Image",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        @Composable
        fun GreetingSection() {
            Text(
                text = "Welcome, User!",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }

        @Composable
        fun NavigationButtons(navController: NavHostController) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = { navController.navigate(ROUT_PROFILE) },
                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    shape = RoundedCornerShape(5.dp))
                {
                    Text(text = "Go to Profile")
                }

                Button(

                    onClick = { navController.navigate(ROUT_SETTINGS) },
                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(text = "Settings")
                }

                Button(
                    onClick = { navController.navigate(ROUT_MESSAGES) },
                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(text = "Messages")
                }
                Button(

                    onClick = { navController.navigate(ROUT_GAMES) },
                    colors = ButtonDefaults.buttonColors(Color.DarkGray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(text = "Go to games")
                }
            }
        }

@Composable
fun BottomNavigationBar (navController: NavHostController) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    NavigationBar(containerColor = MaterialTheme.colorScheme.primary) {
        val items = listOf(
            BottomNavItem("home", Icons.Default.Home, "Home"),
            BottomNavItem("profile", Icons.Default.AccountCircle, "Profile"),
            BottomNavItem("settings", Icons.Default.Settings, "Settings")
        )

        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}

data class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val label: String
)


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
