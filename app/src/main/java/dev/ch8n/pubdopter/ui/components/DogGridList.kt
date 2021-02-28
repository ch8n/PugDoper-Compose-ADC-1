package dev.ch8n.pubdopter.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.ch8n.pubdopter.ui.theme.*


@Composable
fun DogGridList(modifier: Modifier, onClick: (ViewStateDog) -> Unit) {

    val scrollState = rememberLazyListState()

    LazyColumn(
        modifier = modifier,
        state = scrollState
    ) {

        // Add a single item
        items(100) {
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                DogPreviewCard(
                    modifier = Modifier
                        .width(dp200)
                        .height(dp250)
                        .padding(dp8), viewStateDog = ViewStateDog.fake(),
                    onClick = onClick
                )

                DogPreviewCard(
                    modifier = Modifier
                        .width(dp200)
                        .height(dp250)
                        .padding(dp8),
                    viewStateDog = ViewStateDog.fake(),
                    onClick = onClick
                )
            }
        }

    }


}

@Preview(
    showBackground = true,
    heightDp = 200,
    widthDp = 200
)
@Composable
fun PreviewDogList() {
    PubDopterTheme {
        DogGridList(
            modifier = Modifier
                .fillMaxSize()
                .padding(dp16),
            onClick = {}
        )
    }
}