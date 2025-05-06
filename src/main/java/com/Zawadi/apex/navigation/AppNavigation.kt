package com.Zawadi.apex.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.Zawadi.apex.ui.theme.screens.Home.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
        composable("messages") { MessagesScreen(navController) }
    }
}

@Composable
fun ProfileScreen(navController: NavHostController) {
    // Your profile screen content here
    Text(text = "This is the Profile screen!")
}

@Composable
fun SettingsScreen(navController: NavHostController) {
    // Your settings screen content here
    Text(text = "This is the Settings screen!")
}

@Composable
fun MessagesScreen(navController: NavHostController) {
    // Your messages screen content here
    Text(text = "This is the Messages screen!")
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    AppNavigation()
}
