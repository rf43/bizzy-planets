package net.rf43.bizzyplanets.navigation.navhosts

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import net.rf43.bizzyplanets.ui.screens.PlanetsScreen

@Composable
fun PlanetsScreenNavHost(navController: NavController) {
    PlanetsScreen(
        onPlanetSelected = { route ->
            navController.navigate(route)
        }
    )
}