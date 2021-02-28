package dev.ch8n.pubdopter.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import dev.ch8n.pubdopter.ui.components.DogGridList
import dev.ch8n.pubdopter.ui.navigation.Screen
import dev.ch8n.pubdopter.ui.theme.PubDopterTheme
import dev.ch8n.pubdopter.ui.theme.dp8

@Composable
fun HomeScreen(navController: NavHostController) {
    PubDopterTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            DogGridList(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dp8),
                onClick = { dogView ->
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
    HomeScreen(NavHostController(LocalContext.current))
}