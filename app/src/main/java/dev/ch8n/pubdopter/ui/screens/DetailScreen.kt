package dev.ch8n.pubdopter.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.bumptech.glide.request.RequestOptions
import com.github.javafaker.Faker
import dev.ch8n.pubdopter.ui.components.DetailInfoCell
import dev.ch8n.pubdopter.ui.components.DogData
import dev.ch8n.pubdopter.ui.components.DogImageError
import dev.ch8n.pubdopter.ui.components.DogImageLoader
import dev.ch8n.pubdopter.ui.navigation.getArg
import dev.ch8n.pubdopter.ui.theme.*
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun DetailScreen(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.background) {
        val dogData = requireNotNull(navController.getArg<DogData>("dogData"))
        val context = LocalContext.current

        GlideImage(
            data = dogData.avatar,
            contentDescription = dogData.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(dp400),
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

        Box(
            modifier = Modifier.padding(top = dp350, start = dp16, end = dp16, bottom = dp16)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                shape = RoundedCornerShape(dp24),
                backgroundColor = Color.White,
                elevation = defaultElevation
            ) {


                Column(modifier = Modifier.padding(dp16)) {

                    Spacer(modifier = Modifier.height(dp8))

                    Text(
                        text = dogData.name,
                        fontSize = sp28,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Row(modifier = Modifier.padding(top = dp16)) {

                        DetailInfoCell(label = "Gender", value = dogData.gender)

                        Spacer(Modifier.width(dp16))

                        DetailInfoCell(label = "Age", value = dogData.age)

                        Spacer(Modifier.width(dp16))

                        DetailInfoCell(label = "Breed", value = dogData.breed)

                    }

                    Spacer(modifier = Modifier.height(dp16))

                    Text(
                        text = "About",
                        fontSize = sp14,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(dp8))

                    Text(
                        text = Faker.instance().lorem().paragraph(10),
                        fontSize = sp12,
                        fontWeight = FontWeight.Normal
                    )


                    Spacer(modifier = Modifier.height(dp16))

                    Text(
                        text = "Happy Sound",
                        fontSize = sp14,
                        fontWeight = FontWeight.Medium
                    )

                    Text(
                        text = dogData.happySound,
                        fontSize = sp12,
                        fontWeight = FontWeight.Normal
                    )

                    Spacer(modifier = Modifier.height(dp48))

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(dp48),
                        onClick = {
                            Toast.makeText(
                                context,
                                dogData.memePhrase,
                                Toast.LENGTH_SHORT
                            ).show()
                        }) {

                        Text(
                            text = "Adopt ${dogData.name} Now!",
                            fontSize = sp14,
                            fontWeight = FontWeight.Bold
                        )

                    }

                    Spacer(modifier = Modifier.height(dp8))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Button(
                            modifier = Modifier
                                .fillMaxWidth(0.3f)
                                .height(dp48),
                            onClick = {
                                Toast.makeText(
                                    context,
                                    dogData.memePhrase,
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Purple200)
                        ) {

                            Text(
                                text = "favorite",
                                fontSize = sp14,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )

                        }

                        Button(
                            modifier = Modifier
                                .fillMaxWidth(0.7f)
                                .height(dp48),
                            onClick = {
                                Toast.makeText(
                                    context,
                                    dogData.memePhrase,
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Teal200)
                        ) {

                            Text(
                                text = "Book a Visit",
                                fontSize = sp14,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )

                        }
                    }

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
fun PreviewDetailScreen() {
    PubDopterTheme {
        DetailScreen(NavHostController(LocalContext.current))
    }
}