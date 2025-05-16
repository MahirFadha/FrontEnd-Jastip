package com.example.cobaproject.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cobaproject.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.*
import androidx.compose.foundation.clickable

@Composable
fun BerandaScreen(navController: NavController, modifier: Modifier = Modifier) {
    var selectedItem by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "Hi, Adelia", fontSize = 25.sp)

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.bg),
                contentDescription = "Promo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    MenuCard(
                        icon = R.drawable.kurir,
                        label = "Pagi",
                        jamReady = "08.00", // Tambah ini
                        highlighted = selectedItem == "Pagi",
                        modifier = Modifier.weight(1f),
                        onClick = {
                            selectedItem = "Pagi"
                            navController.navigate("pagi")
                        }
                    )

                    MenuCard(
                        icon = R.drawable.kurir,
                        label = "Siang",
                        jamReady = "13.00",
                        highlighted = selectedItem == "Siang",
                        modifier = Modifier.weight(1f),
                        onClick = { selectedItem = "Siang" }
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    MenuCard(
                        icon = R.drawable.kurir,
                        label = "Sore",
                        jamReady = "16.00",
                        highlighted = selectedItem == "Sore",
                        modifier = Modifier.weight(1f),
                        onClick = { selectedItem = "Sore" }
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }

        Image(
            painter = painterResource(id = R.drawable.keranjang),
            contentDescription = "Keranjang",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(32.dp)
        )
    }
}


@Composable
fun MenuCard(
    icon: Int,
    label: String,
    jamReady: String,
    highlighted: Boolean = false,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .aspectRatio(1f)
            .padding(4.dp)
            .clickable { onClick() }
            .background(
                color = if (highlighted) Color(0xFF7B61FF) else Color.White,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = if (highlighted) Color.Transparent else Color.Black,
                shape = RoundedCornerShape(16.dp)
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = label,
            modifier = Modifier.size(45.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            color = if (highlighted) Color.White else Color.Black
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Ready $jamReady",
            fontSize = 12.sp,
            color = if (highlighted) Color.White else Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBerandaScreen() {
    val navController = rememberNavController()
    BerandaScreen(navController = navController)
}
