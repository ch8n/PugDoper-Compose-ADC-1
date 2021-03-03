package dev.ch8n.pubdopter.ui.components

import android.graphics.fonts.FontFamily
import android.os.Build.VERSION.SDK_INT
import android.os.Parcelable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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

// todo move this to model poackage
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
        modifier = modifier.clickable { onClick.invoke(dogData) },
        shape = defaultCardCorner,
        elevation = defaultElevation,
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



        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            CompositionLocalProvider(LocalImageLoader provides imageLoader) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.7f)
                        .padding(start = dp16, end = dp16, top = dp16),
                    shape = defaultCardCorner,
                ) {
                    CoilImage(
                        data = remember(calculation = { dogData.avatar }),
                        contentDescription = dogData.name,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds,
                        loading = {
                            DogImageLoader(Modifier.matchParentSize())
                        }
                    )
                }
            }
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {

            Column(modifier = Modifier.padding(dp16)) {

                Row {
                    Text(
                        text = dogData.name.capitalize(),
                        style = MaterialTheme.typography.h3,
                    )

                    val (asset, color) = if (dogData.gender.toLowerCase() == "male") {
                        R.drawable.ic_male_gender to Color.Blue
                    } else {
                        R.drawable.ic_female to Color.Magenta
                    }

                    Spacer(modifier = Modifier.width(dp2))

                    val genderIcon: Painter = painterResource(id = asset)
                    Icon(
                        painter = genderIcon,
                        contentDescription = null,
                        modifier = Modifier.size(dp12),
                        tint = color
                    )
                }


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = dogData.age.capitalize(),
                        style = MaterialTheme.typography.caption,
                    )

                    Text(
                        text = dogData.gender.capitalize(),
                        style = MaterialTheme.typography.caption,
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