package dev.ch8n.pubdopter

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.ch8n.pubdopter.ui.components.DogInfo
import dev.ch8n.pubdopter.ui.components.ItemDogCard
import dev.ch8n.pubdopter.ui.theme.PubDopterTheme
import dev.ch8n.pubdopter.ui.theme.dp200

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PubDopterTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ItemDogCard(
                        modifier = Modifier
                            .width(dp200)
                            .height(dp200),
                        dogInfo = DogInfo.fake()
                    )
                }
            }
        }
    }
}
