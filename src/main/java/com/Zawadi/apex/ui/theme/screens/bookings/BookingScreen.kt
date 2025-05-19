package com.Zawadi.apex.ui.theme.screens.bookings

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
// Correct import for bookings package

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
 // Ensure this is the correct import for your GameItem class
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter

import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.Zawadi.apex.navigation.Routes.ROUT_BOOKING
import com.Zawadi.apex.navigation.Routes.ROUT_BOOKING_CONFIRMATION
import com.Zawadi.apex.navigation.Routes.ROUT_LOUNGE_CHECKIN

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


// GameItem class with the 'rating' field included


import androidx.compose.ui.graphics.Color as ComposeColor


import kotlinx.serialization.encodeToString

// Function to generate QR code bitmap
fun generateQRCode(text: String): Bitmap {
    val size = 256
    val hints = hashMapOf(EncodeHintType.MARGIN to 1)
    val bitMatrix = MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, size, size, hints)
    val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565)

    // Use toArgb() to convert Compose Color to Int
    val black = ComposeColor.Black.toArgb()
    val white = ComposeColor.White.toArgb()

    for (x in 0 until size) {
        for (y in 0 until size) {
            bitmap.setPixel(x, y, if (bitMatrix[x, y]) black else white)
        }
    }

    return bitmap
}

// Composable to display the QR code
@Composable
fun DisplayQRCode(qrCodeBitmap: Bitmap) {
    Image(
        bitmap = qrCodeBitmap.asImageBitmap(),
        contentDescription = "QR Code",
        modifier = Modifier.size(200.dp)
    )
}



// GameItem data class with a Double for duration
@Serializable
data class GameItem(
    val name: String,
    val price: String,
    val duration: String,  // Duration as Double
    val rating: Double
)


// Composable to display the Booking Confirmation Screen
@Composable
fun BookingConfirmationScreen(navController: NavHostController, game: GameItem) {
    val qrCodeBitmap = remember { mutableStateOf<Bitmap?>(null) }

    // Generate QR code when the game name changes
    LaunchedEffect(game.name) {
        qrCodeBitmap.value = generateQRCode(game.name)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Booking Confirmation", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        // Game Details
        Text("Game: ${game.name}", style = MaterialTheme.typography.bodySmall)
        Text("Cost: ${game.price}", style = MaterialTheme.typography.bodySmall)
        Text("Duration: ${game.duration} hours", style = MaterialTheme.typography.bodySmall)  // Showing duration in hours
        Text("Rating: ${game.rating}", style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.height(16.dp))

        // Display QR Code if available
        qrCodeBitmap.value?.let { bitmap ->
            DisplayQRCode(bitmap)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate(ROUT_LOUNGE_CHECKIN) }) {
            Text("Done")
        }
    }
}

// Function to display QR code (placeholder for now)
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") {
            Button(onClick = {
                val game = GameItem("Cyberpunk 2077", "$60", "2 hours", 4.5) // Correctly passing duration as a Double
                val gameJson = Json.encodeToString(game) // Serializing GameItem object
                navController.navigate("booking_confirmation/$gameJson")
            }) {
                Text("Go to Booking Confirmation")
            }
        }

        composable("booking_confirmation/{gameJson}") { backStackEntry ->
            val gameJson = backStackEntry.arguments?.getString("gameJson")
            val game = gameJson?.let { Json.decodeFromString<GameItem>(it) }

            // Explicitly check if the game is not null and navigate correctly
            if (game != null) {
                BookingConfirmationScreen(navController, game)
            } else {
                Text("Error loading game data")
            }
        }
    }
}

// Preview of the Booking Confirmation Screen
@Preview(showBackground = true)
@Composable
fun BookingConfirmationPreview() {
    val navController = rememberNavController()
    SetupNavGraph(navController)
}
