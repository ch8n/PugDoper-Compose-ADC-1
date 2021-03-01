package dev.ch8n.pubdopter.ui.screens

import android.content.res.Resources
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import dev.ch8n.pubdopter.ui.components.DogGridList
import dev.ch8n.pubdopter.ui.navigation.Screen
import dev.ch8n.pubdopter.ui.navigation.addArg
import dev.ch8n.pubdopter.ui.theme.*

@Composable
fun HomeScreen(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dp48)
            ) {
                Text(
                    text = "pugDopter".capitalize(),
                    color = Color.White,
                    fontSize = sp18,
                    fontWeight = FontWeight.ExtraBold
                )
            }
            DogGridList(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dp8),
                onClick = { dogView ->
                    navController.addArg("dogData" to dogView)
                    navController.navigate(Screen.Detail.route)
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    heightDp = 200,
    widthDp = 200
)
@Composable
fun PreviewHomeScreen() {
    PubDopterTheme {
        HomeScreen(NavHostController(LocalContext.current))
    }
}