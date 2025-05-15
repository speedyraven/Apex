package com.Zawadi.apex.ui.theme.screens.Home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun SettingsScreen(navController: NavHostController) {
    // State for the toggle (e.g., sound setting)
    var isSoundEnabled by remember { mutableStateOf(true) }
    var isNotificationsEnabled by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Title
            Text(
                text = "App Settings",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Sound setting toggle
            SettingItem(
                label = "Sound",
                toggleState = isSoundEnabled,
                onToggleChanged = { isSoundEnabled = it }
            )

            // Notifications setting toggle
            SettingItem(
                label = "Notifications",
                toggleState = isNotificationsEnabled,
                onToggleChanged = { isNotificationsEnabled = it }
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Privacy Button
            Button(
                onClick = { /* Navigate to Privacy Settings */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Privacy Settings")
            }
        }
    }
}

@Composable
fun SettingItem(
    label: String,
    toggleState: Boolean,
    onToggleChanged: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, modifier = Modifier.weight(1f), fontSize = 18.sp)
        Switch(
            checked = toggleState,
            onCheckedChange = onToggleChanged,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSettingsScreen() {
    SettingsScreen(navController = rememberNavController())
}


