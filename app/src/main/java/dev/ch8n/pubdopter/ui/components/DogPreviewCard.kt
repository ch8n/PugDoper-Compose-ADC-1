package dev.ch8n.pubdopter.ui.components

import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Parcelable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.github.javafaker.Faker
import dev.ch8n.pubdopter.R
import dev.ch8n.pubdopter.ui.theme.*
import dev.ch8n.pubdopter.ui.utils.Fake
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.coil.LocalImageLoader
import kotlinx.android.parcel.Parcelize


@Parcelize
data class DogData(
    val name: String,
    val breed: String,
    val gender: String,
    val size: String,
    val happySound: String,
    val memePhrase: String,
    val age: String,
    val avatar: String
) : Parcelable {
    companion object {
        fun fake() = with(Faker.instance().dog()) {
            DogData(
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
    dogData: DogData,
    onClick: (DogData) -> Unit
) {
    Card(
        modifier = modifier.clickable {
            onClick.invoke(dogData)
        },
        shape = RoundedCornerShape(dp8),
        elevation = defaultElevation,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomStart
        ) {

            val imageLoader = ImageLoader.Builder(LocalContext.current)
                .componentRegistry {
                    if (SDK_INT >= 28) {
                        add(ImageDecoderDecoder())
                    } else {
                        add(GifDecoder())
                    }
                }
                .build()

            CompositionLocalProvider(LocalImageLoader provides imageLoader) {
                CoilImage(
                    data = remember(calculation = { dogData.avatar }),
                    contentDescription = dogData.name,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillWidth,
                    loading = {
                        DogImageLoader(Modifier.matchParentSize())
                    }
                )
            }
            CoilImage(
                data = R.drawable.gradient,
                contentDescription = dogData.name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
            )

            Column(modifier = Modifier.padding(dp8)) {
                Text(
                    text = dogData.name.capitalize(),
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(text = dogData.breed, color = Color.White)
                Row {
                    Text(
                        text = dogData.age.capitalize(),
                        color = Color.White,
                        fontSize = sp12
                    )
                    Spacer(Modifier.width(dp8))
                    Text(
                        text = dogData.gender.capitalize(),
                        color = Color.White,
                        fontSize = sp12
                    )
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
            dogData = DogData.fake(),
            modifier = Modifier
                .fillMaxWidth()
                .height(dp200)
                .padding(8.dp),
            onClick = {}
        )
    }
}