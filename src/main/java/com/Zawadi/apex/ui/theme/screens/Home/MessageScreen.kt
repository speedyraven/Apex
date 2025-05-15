package com.Zawadi.apex.ui.theme.screens.Home

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun MessageScreen(navController: NavHostController) {
    // Sample list of initial messages
    var messages = remember { mutableStateListOf(
        "Hello there!",
        "How are you doing?",
        "Good to see you!"
    ) }

    var messageText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Displaying the list of messages
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            items(messages) { message ->
                MessageItem(message)
            }
        }

        // Input Field for New Message
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            TextField(
                value = messageText,
                onValueChange = { messageText = it },
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Gray.copy(alpha = 0.1f))
                    .padding(12.dp),
                placeholder = { Text(text = "Type a message...") }
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Send Button
            Button(onClick = {
                if (messageText.isNotEmpty()) {
                    // Add new message to the list
                    messages.add(messageText)
                    messageText = "" // Clear the input field after sending
                }
            }) {
                Text(text = "Send")
            }
        }
    }
}

@Composable
fun MessageItem(message: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        // Display each message
        Text(
            text = message,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageScreen() {
    MessageScreen(navController = rememberNavController())
}
