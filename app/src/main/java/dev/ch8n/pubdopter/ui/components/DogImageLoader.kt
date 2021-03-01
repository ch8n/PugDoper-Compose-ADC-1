package dev.ch8n.pubdopter.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import dev.ch8n.pubdopter.R
import dev.ch8n.pubdopter.ui.theme.PubDopterTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DogImageLoader(modifier: Modifier) {
    Box(modifier = modifier) {
        CoilImage(
            data = R.raw.light_dog_run,
            contentDescription = "Loading",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth,
        )
    }
}

@Preview(
    showBackground = true,
    heightDp = 200,
    widthDp = 200
)
@Composable
fun PreviewDogImageLoader() {
    PubDopterTheme {
        DogImageLoader(
            modifier = Modifier.fillMaxSize()
        )
    }
}