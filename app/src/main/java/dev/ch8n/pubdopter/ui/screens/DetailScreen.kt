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
import dev.ch8n.pubdopter.ui.components.DogPreviewCard
import dev.ch8n.pubdopter.ui.components.ViewStateDog
import dev.ch8n.pubdopter.ui.navigation.getArg
import dev.ch8n.pubdopter.ui.theme.PubDopterTheme
import dev.ch8n.pubdopter.ui.theme.dp8

@Composable
fun DetailScreen(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.background) {
        val dogData = navController.getArg<ViewStateDog>("dogData")
        DogPreviewCard(
            modifier = Modifier
                .fillMaxSize()
                .padding(dp8),
            viewStateDog = requireNotNull(dogData),
            onClick = {}
        )
    }
}

@Preview(
    showBackground = true,
    heightDp = 200,
    widthDp = 200
)
@Composable
fun PreviewDetailScreen() {
    PubDopterTheme {
        DetailScreen(NavHostController(LocalContext.current))
    }
}