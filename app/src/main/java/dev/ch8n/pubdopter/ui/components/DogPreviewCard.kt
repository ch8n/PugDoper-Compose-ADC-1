package dev.ch8n.pubdopter.ui.components

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.request.RequestOptions
import com.github.javafaker.Faker
import dev.ch8n.pubdopter.R
import dev.ch8n.pubdopter.ui.theme.*
import dev.ch8n.pubdopter.ui.utils.Fake
import dev.chrisbanes.accompanist.glide.GlideImage


data class ViewStateDog(
    val name: String,
    val breed: String,
    val gender: String,
    val size: String,
    val happySound: String,
    val memePhrase: String,
    val age: String,
    val avatar: String
) {
    companion object {
        fun fake() = with(Faker.instance().dog()) {
            ViewStateDog(
                name = name(),
                breed = breed(),
                gender = gender(),
                size = size(),
                happySound = sound(),
                memePhrase = memePhrase(),
                age = age(),
                avatar = Fake.randomDog
            )
        }
    }
}

@Composable
fun DogPreviewCard(
    modifier: Modifier,
    viewStateDog: ViewStateDog,
    onClick: (ViewStateDog) -> Unit
) {
    Card(
        modifier = modifier.clickable {
            onClick.invoke(viewStateDog)
        },
        shape = RoundedCornerShape(dp8),
        elevation = defaultElevation,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomStart
        ) {

            GlideImage(
                data = viewStateDog.avatar,
                contentDescription = viewStateDog.name,
                modifier = Modifier.fillMaxSize(),
                requestBuilder = {
                    val options = RequestOptions()
                    options.centerCrop()
                    apply(options)
                },
                loading = {
                    DogImageLoader(Modifier.matchParentSize())
                },
                error = {
                    DogImageError(Modifier.matchParentSize())
                }
            )

            Column(modifier = Modifier.padding(dp8)) {
                Text(
                    text = viewStateDog.name.capitalize(),
                    fontWeight = FontWeight.Bold
                )
                Text(viewStateDog.breed)
                Row {
                    Text(text = viewStateDog.age.capitalize(), fontSize = sp12)
                    Spacer(Modifier.width(dp8))
                    Text(text = viewStateDog.gender.capitalize(), fontSize = sp12)
                }

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
fun PreviewDogCard() {
    PubDopterTheme {
        DogPreviewCard(
            viewStateDog = ViewStateDog.fake(),
            modifier = Modifier
                .fillMaxWidth()
                .height(dp200)
                .padding(8.dp),
            onClick = {}
        )
    }
}