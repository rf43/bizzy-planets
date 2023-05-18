package net.rf43.bizzyplanets.navigation.navhosts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import net.rf43.bizzyplanets.ui.screens.ScreensViewModel
import net.rf43.bizzyplanets.ui.screens.detail.DetailScreen

@Composable
fun DetailScreenNavHost(
    navController: NavController,
    planetName: String
) {
    val viewModel: ScreensViewModel = hiltViewModel()
    viewModel.fetchPlanetDetails(planetName)

    DetailScreen(
        planetDetail = viewModel.planetDetailStateFlow.collectAsState().value,
        onBackSelected = {
            navController.popBackStack()
        }
    )
}