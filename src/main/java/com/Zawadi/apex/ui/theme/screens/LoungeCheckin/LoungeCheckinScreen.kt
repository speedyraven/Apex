package com.Zawadi.apex.ui.theme.screens.LoungeCheckin



import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix

// QR Code Generation Function
fun generateQRCode(content: String, size: Int = 512): Bitmap? {
    return try {
        val bitMatrix: BitMatrix = MultiFormatWriter().encode(
            content,
            BarcodeFormat.QR_CODE,
            size,
            size
        )
        val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565)
        for (x in 0 until size) {
            for (y in 0 until size) {
                bitmap.setPixel(x, y, if (bitMatrix[x, y]) android.graphics.Color.BLACK else android.graphics.Color.WHITE)
            }
        }
        bitmap
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

// QR Code Display Composable
@Composable
fun QRCodeDisplay(content: String) {
    val qrBitmap: Bitmap? = generateQRCode(content)
    if (qrBitmap != null) {
        Image(
            bitmap = qrBitmap.asImageBitmap(),
            contentDescription = "QR Code",
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp)
        )
    } else {
        Text(text = "Failed to generate QR code")
    }
}

// Lounge Check-In Screen Composable
@Composable
fun LoungeCheckInScreen(userId: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Lounge Check-In", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))

        // Display the User's Booking ID
        Text(text = "Booking ID: $userId", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(16.dp))

        // Display the QR Code based on the user ID
        QRCodeDisplay(content = userId)

        Spacer(modifier = Modifier.height(32.dp))

        // Optional: Button for the user to confirm check-in
        Button(
            onClick = { /* Handle check-in confirmation */ },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text(text = "Confirm Check-In")
        }
    }
}

// Preview of the Lounge Check-In Screen
@Preview(showBackground = true)
@Composable
fun PreviewLoungeCheckInScreen() {
    LoungeCheckInScreen(userId = "Apex12345")
}
