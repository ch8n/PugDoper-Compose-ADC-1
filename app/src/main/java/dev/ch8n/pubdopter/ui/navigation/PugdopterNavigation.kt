package dev.ch8n.pubdopter.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.ch8n.pubdopter.ui.screens.DetailScreen
import dev.ch8n.pubdopter.ui.screens.HomeScreen


sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail")
}


@Composable
fun PugDopterNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.Detail.route) {
            DetailScreen(navController = navController)
        }
    }
}
