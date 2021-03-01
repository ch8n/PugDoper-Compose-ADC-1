package dev.ch8n.pubdopter.ui.components

import android.os.Parcelable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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

            GlideImage(
                data = remember(calculation = { dogData.avatar }),
                contentDescription = dogData.name,
                modifier = Modifier.fillMaxSize(),
                requestBuilder = {
                    val options = RequestOptions()
                    options.centerCrop()
                    apply(options)
                },
                loading = {
                    DogImageLoader(Modifier.matchParentSize())
                }
            )

            GlideImage(
                data = R.drawable.gradient,
                contentDescription = dogData.name,
                modifier = Modifier.fillMaxSize(),
                requestBuilder = {
                    val options = RequestOptions()
                    options.centerCrop()
                    apply(options)
                }
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