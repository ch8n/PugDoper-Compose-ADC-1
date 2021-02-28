package dev.ch8n.pubdopter.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.request.RequestOptions
import dev.ch8n.pubdopter.R
import dev.ch8n.pubdopter.ui.theme.PubDopterTheme
import dev.ch8n.pubdopter.ui.theme.dp200
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun DogImageError(modifier: Modifier) {
    Box(modifier = modifier) {
        GlideImage(
            data = R.raw.light_dog_angry,
            contentDescription = "Loading",
            modifier = Modifier.fillMaxSize(),
            requestBuilder = {
                val options = RequestOptions()
                options.centerCrop()
                apply(options)
            },
        )
    }
}

@Preview(
    showBackground = true,
    heightDp = 200,
    widthDp = 200
)
@Composable
fun PreviewDogImageError() {
    PubDopterTheme {
        DogImageError(
            modifier = Modifier.fillMaxSize()
        )
    }
}