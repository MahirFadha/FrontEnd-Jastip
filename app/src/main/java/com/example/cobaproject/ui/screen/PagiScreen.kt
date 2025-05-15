package com.example.cobaproject.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PagiScreen(navController: NavController, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Selamat datang di PagiScreen!")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPagiScreen() {
    val navController = rememberNavController()
    PagiScreen(navController = navController)
}

