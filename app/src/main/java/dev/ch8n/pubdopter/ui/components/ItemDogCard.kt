package dev.ch8n.pubdopter.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.javafaker.Faker
import dev.ch8n.pubdopter.R
import dev.ch8n.pubdopter.ui.theme.*


data class DogInfo(
    val name: String,
    val breed: String,
    val gender: String,
    val size: String,
    val happySound: String,
    val memePhrase: String,
    val age: String,
) {
    companion object {
        fun fake() = with(Faker.instance().dog()) {
            DogInfo(
                name = name(),
                breed = breed(),
                gender = gender(),
                size = size(),
                happySound = sound(),
                memePhrase = memePhrase(),
                age = age()
            )
        }
    }
}

@Composable
fun ItemDogCard(modifier: Modifier, dogInfo: DogInfo) {
    Card(
        modifier = modifier,
        elevation = defaultElevation,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomStart
        ) {
            val image: Painter = painterResource(id = R.drawable.ic_launcher_background)
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = image,
                contentDescription = ""
            )

            Column(modifier = Modifier.padding(dp8)) {
                Text(
                    text = dogInfo.name.capitalize(),
                    fontWeight = FontWeight.Bold
                )
                Text(dogInfo.breed)
                Row {
                    Text(text = dogInfo.age.capitalize(), fontSize = sp12)
                    Spacer(Modifier.width(dp8))
                    Text(text = dogInfo.gender.capitalize(), fontSize = sp12)
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
        ItemDogCard(
            dogInfo = DogInfo.fake(),
            modifier = Modifier
                .fillMaxWidth()
                .height(dp200)
                .padding(8.dp)
        )
    }
}