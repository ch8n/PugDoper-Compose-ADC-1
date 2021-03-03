package dev.ch8n.pubdopter.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import dev.ch8n.pubdopter.R
import dev.ch8n.pubdopter.ui.components.DogGridList
import dev.ch8n.pubdopter.ui.navigation.Screen
import dev.ch8n.pubdopter.ui.navigation.addArg
import dev.ch8n.pubdopter.ui.theme.*

@Composable
fun HomeScreen(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.background) {

        Column(modifier = Modifier.fillMaxSize()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = dp16,
                        top = dp16,
                        end = dp16
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "PugDopter",
                    style = MaterialTheme.typography.h1
                )

                val adpotIcon: Painter = painterResource(id = R.drawable.ic_adapot)
                Icon(
                    painter = adpotIcon,
                    contentDescription = null,
                    modifier = Modifier.size(dp36),
                    tint = TextColor
                )
            }


            DogGridList(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dp8),
                onClick = { dogView ->
                    navController.addArg("dogData" to dogView)
                    navController.navigate(Screen.Detail.route)
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    heightDp = 200,
    widthDp = 200
)
@Composable
fun PreviewHomeScreen() {
    PubDopterTheme {
        HomeScreen(NavHostController(LocalContext.current))
    }
}