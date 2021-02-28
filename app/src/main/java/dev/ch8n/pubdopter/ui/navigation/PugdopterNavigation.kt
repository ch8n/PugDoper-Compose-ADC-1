package dev.ch8n.pubdopter.ui.navigation

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.ch8n.pubdopter.ui.screens.DetailScreen
import dev.ch8n.pubdopter.ui.screens.HomeScreen


sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail")
}

fun <T : Parcelable> NavController.getArg(key: String): T? {
    return previousBackStackEntry?.arguments?.getParcelable<T>(key)
}

fun <T : Parcelable> NavController.addArg(keyValue: Pair<String, T>): NavController {
    currentBackStackEntry?.arguments?.putParcelable(keyValue.first, keyValue.second)
    return this
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
