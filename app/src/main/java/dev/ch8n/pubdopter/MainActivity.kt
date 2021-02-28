package dev.ch8n.pubdopter

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.ch8n.pubdopter.ui.components.DogGridList
import dev.ch8n.pubdopter.ui.navigation.PugDopterNavigation
import dev.ch8n.pubdopter.ui.theme.PubDopterTheme
import dev.ch8n.pubdopter.ui.theme.dp8

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PubDopterTheme {
                // A surface container using the 'background' color from the theme
                PugDopterNavigation()
            }
        }
    }
}

