package net.rf43.bizzyplanets.navigation.navhosts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import net.rf43.bizzyplanets.ui.screens.DetailScreen
import net.rf43.bizzyplanets.ui.screens.ScreensViewModel

@Composable
fun DetailScreenNavHost(
    navController: NavController,
    planetName: String
) {
    val viewModel: ScreensViewModel = hiltViewModel()
    viewModel.fetchPlanetDetails(planetName)

    DetailScreen(
        planet = viewModel.planetDetailStateFlow.collectAsState().value,
        onBackSelected = { route ->
            navController.navigate(route)
        }
    )
}