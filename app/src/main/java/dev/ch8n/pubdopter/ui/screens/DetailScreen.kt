package dev.ch8n.pubdopter.ui.screens

import android.os.Build
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.github.javafaker.Faker
import dev.ch8n.pubdopter.R
import dev.ch8n.pubdopter.ui.components.DetailInfoCell
import dev.ch8n.pubdopter.ui.components.DogData
import dev.ch8n.pubdopter.ui.components.DogImageError
import dev.ch8n.pubdopter.ui.components.DogImageLoader
import dev.ch8n.pubdopter.ui.navigation.getArg
import dev.ch8n.pubdopter.ui.theme.*
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.coil.LocalImageLoader
import java.text.DateFormat
import java.text.SimpleDateFormat


@Composable
fun DetailScreen(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.background) {


        val dogData = requireNotNull(navController.getArg<DogData>("dogData"))
        val context = LocalContext.current

        val imageLoader = ImageLoader.Builder(LocalContext.current)
            .componentRegistry {
                if (Build.VERSION.SDK_INT >= 28) {
                    add(ImageDecoderDecoder())
                } else {
                    add(GifDecoder())
                }
            }
            .build()

        CompositionLocalProvider(LocalImageLoader provides imageLoader) {
            CoilImage(
                data = dogData.avatar,
                contentDescription = dogData.name,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dp400),
                loading = {
                    DogImageLoader(Modifier.matchParentSize())
                },
                error = {
                    DogImageError(Modifier.matchParentSize())
                }
            )
        }



        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp, start = 16.dp, end = 16.dp),
                shape = RoundedCornerShape(dp24),
                backgroundColor = Color.White,
                elevation = defaultElevation
            ) {


                Column(modifier = Modifier.padding(dp16)) {

                    Spacer(modifier = Modifier.height(dp8))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = dogData.name,
                            fontSize = sp28,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Spacer(modifier = Modifier.width(dp8))

                        val genderRes = if (dogData.gender.toLowerCase() == "male") {
                            R.drawable.ic_male_gender
                        } else {
                            R.drawable.ic_female
                        }
                        val genderIcon: Painter = painterResource(id = genderRes)
                        Icon(
                            painter = genderIcon,
                            contentDescription = null,
                            modifier = Modifier.size(dp24),
                            tint = Color.Gray
                        )
                    }



                    Row(modifier = Modifier.padding(top = dp16)) {

                        val df: DateFormat = SimpleDateFormat("MM/dd")
                        val date = Faker.instance().date().birthday()
                        val startDate: String = df.format(date)

                        DetailInfoCell(label = "DOB", value = startDate)

                        Spacer(Modifier.width(dp16))

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
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Teal200)
                    ) {

                        val homeIcon: Painter = painterResource(id = R.drawable.ic_home)
                        Icon(
                            painter = homeIcon,
                            contentDescription = null,
                            modifier = Modifier.size(dp16),
                            tint = Color.White
                        )

                        Spacer(modifier = Modifier.width(dp16))

                        Text(
                            text = "Adopt ${dogData.name} Now!",
                            fontSize = sp14,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                    }

                    Spacer(modifier = Modifier.height(dp8))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Button(
                            modifier = Modifier
                                .fillMaxWidth(0.35f)
                                .height(dp48),
                            onClick = {
                                Toast.makeText(
                                    context,
                                    dogData.memePhrase,
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta)
                        ) {


                            val homeIcon: Painter = painterResource(id = R.drawable.ic_like)
                            Icon(
                                painter = homeIcon,
                                contentDescription = null,
                                modifier = Modifier.size(dp16),
                                tint = Color.White
                            )

                            Spacer(modifier = Modifier.width(dp16))


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
                            }
                        ) {

                            val homeIcon: Painter = painterResource(id = R.drawable.ic_location)
                            Icon(
                                painter = homeIcon,
                                contentDescription = null,
                                modifier = Modifier.size(dp16),
                                tint = Color.White
                            )

                            Spacer(modifier = Modifier.width(dp16))

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