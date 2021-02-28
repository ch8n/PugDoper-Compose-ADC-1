package dev.ch8n.pubdopter.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.ch8n.pubdopter.ui.theme.*
import dev.ch8n.pubdopter.ui.utils.Fake.doggies


@Composable
fun DogGridList(modifier: Modifier, onClick: (DogData) -> Unit) {

    val scrollState = rememberLazyListState()

    LazyColumn(
        modifier = modifier,
        state = scrollState
    ) {

        itemsIndexed(doggies) { index: Int, dog: DogData ->
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                DogPreviewCard(
                    modifier = Modifier
                        .width(dp200)
                        .height(dp250)
                        .padding(dp8), dogData = doggies[index],
                    onClick = onClick
                )

                DogPreviewCard(
                    modifier = Modifier
                        .width(dp200)
                        .height(dp250)
                        .padding(dp8),
                    dogData = doggies[doggies.lastIndex - index],
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