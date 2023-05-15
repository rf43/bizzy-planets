package net.rf43.bizzyplanets.navigation.navhosts

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import net.rf43.bizzyplanets.ui.screens.DetailScreen

@Composable
fun DetailScreenNavHost(navController: NavController) {
    DetailScreen(
        onBackSelected = { route ->
            navController.navigate(route)
        }
    )
}