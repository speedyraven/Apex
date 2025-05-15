package com.Zawadi.apex.ui.theme.screens.GameProfile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.Zawadi.apex.navigation.ROUT_ADDPAYMENT
import com.Zawadi.apex.navigation.ROUT_BOOKING
import com.Zawadi.apex.navigation.ROUT_EDITPROFILE
import com.Zawadi.apex.navigation.ROUT_HOME

@Composable
fun GameProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Personal Information Section
        Text("Personal Information", style = MaterialTheme.typography.headlineMedium)
        PersonalInfoSection(navController)

        Spacer(modifier = Modifier.height(16.dp))

        // Payment Methods Section
        Text("Payment Methods", style = MaterialTheme.typography.headlineMedium)
        PaymentMethodsSection(navController)

        Spacer(modifier = Modifier.height(16.dp))

        // Past Bookings Section
        Text("Past Bookings & Payment History", style = MaterialTheme.typography.headlineMedium)
        PastBookingsSection()
    }
}

@Composable
fun PersonalInfoSection(navController: NavHostController) {
    // Example of user info, you can replace this with actual user data
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Name: John Doe")
        Text("Email: johndoe@example.com")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate(ROUT_EDITPROFILE) },
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(5.dp)) {
            Text("Edit Info")
        }
        Button(onClick = { navController.navigate(ROUT_BOOKING) },
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(5.dp)) {
            Text("Go to booking")
        }
    }
}

@Composable
fun PaymentMethodsSection(navController: NavHostController) {
    // Example of payment methods list, can be dynamic
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Card ending in 1234")
        Text("Expired: 12/24")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate(ROUT_ADDPAYMENT) },
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(5.dp)) {
            Text("Add Payment Method")
        }
    }
}

@Composable
fun PastBookingsSection() {
    // Example of past bookings and payments list, can be dynamic
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Booking #1 - 12/01/2025")
        Text("Amount: \$50")
        Text("Status: Paid")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Booking #2 - 14/01/2025")
        Text("Amount: \$30")
        Text("Status: Paid")
    }
}

@Preview(showBackground = true)
@Composable
fun GameProfileScreenPreview() {
    GameProfileScreen(navController = rememberNavController())
}