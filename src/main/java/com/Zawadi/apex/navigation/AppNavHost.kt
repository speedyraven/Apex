package com.Zawadi.apex.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.Zawadi.apex.ui.theme.screens.Admin.AddGameScreen
import com.Zawadi.apex.ui.theme.screens.Admin.AdminPanelScreen
import com.Zawadi.apex.ui.theme.screens.Admin.EditGameScreen
import com.Zawadi.apex.ui.theme.screens.GameProfile.AddPaymentMethodScreen
import com.Zawadi.apex.ui.theme.screens.GameProfile.EditProfileScreen
import com.Zawadi.apex.ui.theme.screens.GameProfile.GameProfileScreen
import com.Zawadi.apex.ui.theme.screens.signup.SignupScreen
import com.Zawadi.apex.ui.theme.screens.about.AboutScreen
import com.Zawadi.apex.ui.theme.screens.Home.HomeScreen
import com.Zawadi.apex.ui.theme.screens.Home.MessageScreen
import com.Zawadi.apex.ui.theme.screens.Home.ProfileScreen
import com.Zawadi.apex.ui.theme.screens.Home.SettingsScreen
import com.Zawadi.apex.ui.theme.screens.bookings.BookingConfirmationScreen
import com.Zawadi.apex.ui.theme.screens.bookings.GameItem
import com.Zawadi.apex.ui.theme.screens.bookings.SetupNavGraph

import com.Zawadi.apex.ui.theme.screens.games.GameSelectionScreen
import com.Zawadi.apex.ui.theme.screens.login.LoginScreen
import com.Zawadi.apex.ui.theme.screens.payment.PaymentScreen
import com.Zawadi.apex.ui.theme.screens.payment.SuccessScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_ABOUT
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUT_SIGNUP) {
            SignupScreen(navController = navController)
        }
        composable(ROUT_LOGIN) {
            LoginScreen(navController = navController)
        }
        composable(ROUT_PAYMENT) {
            PaymentScreen(navController)
        }
        composable(ROUT_SECCESS) {
            Text("Payment Successful!")
        }

        // Add missing routes for profile, settings, and messages
        composable(ROUT_PROFILE) {
            ProfileScreen(navController)
        }
        composable(ROUT_SETTINGS) {
            SettingsScreen(navController)
        }
        composable(ROUT_MESSAGES) {
            MessageScreen(navController)
        }
        composable(ROUT_GAMEPROFILE) {
            GameProfileScreen(navController)
        }
        composable(ROUT_EDITPROFILE) {
            EditProfileScreen(navController)
        }
        composable(ROUT_ADDPAYMENT) {
            AddPaymentMethodScreen(navController)
        }
        composable(ROUT_GAMES) {
            GameSelectionScreen(navController)
        }
        composable(ROUT_SECCESS) {
            SuccessScreen(navController)
        }
        composable(ROUT_BOOKING) {
            SetupNavGraph(navController)
        }
        composable(ROUT_BOOKING) {
            val game = GameItem("Cyberpunk 2077", "$60", "2 hours", 4.5)  // Duration as Double
            BookingConfirmationScreen(navController, game)
        }
        composable(ROUT_ADMIN) {
            AdminPanelScreen(navController)
        }
        composable(ROUT_ADDGAME) {
            AddGameScreen(navController)
        }
        composable(ROUT_EDITGAME) { backStackEntry ->
            val gameId = backStackEntry.arguments?.getString("gameId")
            val game = getGameById(gameId) // Fetch game details by gameId
            EditGameScreen(navController, game)
        }
    }
}






