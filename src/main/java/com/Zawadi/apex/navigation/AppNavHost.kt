package com.Zawadi.apex.navigation

import android.widget.Toast
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.Zawadi.apex.navigation.Routes.ROUT_ABOUT
import com.Zawadi.apex.navigation.Routes.ROUT_ADDGAME
import com.Zawadi.apex.navigation.Routes.ROUT_SIGNUP
import com.Zawadi.apex.ui.theme.screens.Admin.AddGamesScreen


import com.Zawadi.apex.ui.theme.screens.Admin.EditGamesScreen
import com.Zawadi.apex.ui.theme.screens.Admin.GamesViewScreen
import com.Zawadi.apex.ui.theme.screens.GameProfile.AddPaymentMethodScreen
import com.Zawadi.apex.ui.theme.screens.GameProfile.EditProfileScreen
import com.Zawadi.apex.ui.theme.screens.GameProfile.GameProfileScreen
import com.Zawadi.apex.ui.theme.screens.signup.SignupScreen
import com.Zawadi.apex.ui.theme.screens.about.AboutScreen
import com.Zawadi.apex.ui.theme.screens.Home.HomeScreen
import com.Zawadi.apex.ui.theme.screens.Home.MessageScreen
import com.Zawadi.apex.ui.theme.screens.Home.ProfileScreen
import com.Zawadi.apex.ui.theme.screens.Home.SettingsScreen
import com.Zawadi.apex.ui.theme.screens.LoungeCheckin.LoungeCheckInScreen
import com.Zawadi.apex.ui.theme.screens.bookings.BookingConfirmationScreen
import com.Zawadi.apex.ui.theme.screens.bookings.GameItem
import com.Zawadi.apex.ui.theme.screens.bookings.SetupNavGraph

import com.Zawadi.apex.ui.theme.screens.games.GameSelectionScreen
import com.Zawadi.apex.ui.theme.screens.login.LoginScreen
import com.Zawadi.apex.ui.theme.screens.payment.PaymentScreen
import com.Zawadi.apex.ui.theme.screens.payment.SuccessScreen
import com.stripe.android.customersheet.injection.CustomerSheetViewModelModule_Companion_ContextFactory.context

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_ABOUT,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {


        composable(Routes.ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(Routes.ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(Routes.ROUT_SIGNUP) {
            SignupScreen(navController)
        }
        composable(Routes.ROUT_LOGIN) {
            LoginScreen(navController)
        }
        composable(Routes.ROUT_PAYMENT) {
            PaymentScreen(navController)
        }
        composable(Routes.ROUT_SUCCESS) {
            SuccessScreen(navController)
        }
        composable(Routes.ROUT_PROFILE) {
            ProfileScreen(navController)
        }
        composable(Routes.ROUT_SETTINGS) {
            SettingsScreen(navController)
        }
        composable(Routes.ROUT_MESSAGES) {
            MessageScreen(navController)
        }
        composable(Routes.ROUT_GAMEPROFILE) {
            GameProfileScreen(navController)
        }
        composable(Routes.ROUT_EDITPROFILE) {
            EditProfileScreen(navController)
        }
        composable(Routes.ROUT_ADDPAYMENT) {
            AddPaymentMethodScreen(navController)
        }
        composable(Routes.ROUT_GAMES) {
            GameSelectionScreen(navController)
        }
        composable(Routes.ROUT_ADDGAME) {
            AddGamesScreen(navController)
        }
        composable(Routes.ROUT_GAMES_VIEW) {
            GamesViewScreen(navController)
        }

            // Booking flow split into two screens with different routes
        composable(Routes.ROUT_BOOKING_CONFIRMATION) {
            val game = GameItem("Cyberpunk 2077", "$60", "2 hours", 4.5)
            BookingConfirmationScreen(navController, game)
        }

        composable(Routes.ROUT_BOOKING_CONFIRMATION) {
                val game = GameItem("Cyberpunk 2077", "$60", "2 hours", 4.5)
                BookingConfirmationScreen(navController, game)
            }
        composable(
            route = Routes.ROUT_LOUNGE_CHECKIN,
            arguments = listOf(navArgument("userId") { type = NavType.StringType })
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId") ?: "Unknown"
            LoungeCheckInScreen(navController, userId)
        }


        // Edit game with ID parameter
            composable(
                route = Routes.ROUT_EDITGAME,
                arguments = listOf(navArgument("gamesId") { type = NavType.StringType })
            ) { backStackEntry ->
                val gamesId = backStackEntry.arguments?.getString("gamesId")
                if (gamesId != null) {
                    EditGamesScreen(navController = navController, gamesId = gamesId)
                }
            }

        }}

