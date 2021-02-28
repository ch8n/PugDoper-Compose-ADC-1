package dev.ch8n.pubdopter.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import dev.ch8n.pubdopter.ui.components.DogGridList
import dev.ch8n.pubdopter.ui.components.DogPreviewCard
import dev.ch8n.pubdopter.ui.components.ViewStateDog
import dev.ch8n.pubdopter.ui.theme.PubDopterTheme
import dev.ch8n.pubdopter.ui.theme.dp200
import dev.ch8n.pubdopter.ui.theme.dp250
import dev.ch8n.pubdopter.ui.theme.dp8

@Composable
fun DetailScreen(navController: NavHostController) {
    PubDopterTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            DogPreviewCard(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dp8),
                viewStateDog = ViewStateDog.fake(),
                onClick = {}
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
fun PreviewDetailScreen() {
    DetailScreen(NavHostController(LocalContext.current))
}