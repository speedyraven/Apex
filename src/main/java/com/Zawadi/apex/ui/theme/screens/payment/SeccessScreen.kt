package com.Zawadi.apex.ui.theme.screens.payment

import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.Zawadi.apex.navigation.ROUT_BOOKING


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuccessScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Payment Success") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Payment Successful!", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    // Navigate to the Home screen or any other destination
                    navController.navigate(ROUT_BOOKING) {
                        // Clear back stack to avoid returning to success screen
                        popUpTo("payment") { inclusive = true }
                    }
                }
            ) {
                Text("Go to Booking")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuccessScreenPreview() {
    SuccessScreen(navController = rememberNavController())
}
