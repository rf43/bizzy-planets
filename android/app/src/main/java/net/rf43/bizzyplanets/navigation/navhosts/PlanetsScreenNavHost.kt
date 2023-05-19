package net.rf43.bizzyplanets.navigation.navhosts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import net.rf43.bizzyplanets.navigation.DetailScreen
import net.rf43.bizzyplanets.ui.screens.ScreensViewModel
import net.rf43.bizzyplanets.ui.screens.planets.PlanetsScreen

@Composable
fun PlanetsScreenNavHost(navController: NavController) {
    val viewModel: ScreensViewModel = hiltViewModel()

    PlanetsScreen(
        homeTitle = viewModel.homeContentTitle.collectAsState().value,
        homeSubtitle = viewModel.homeContentSubtitle.collectAsState().value,
        planetList = viewModel.allPlanetsStateFlow.collectAsState().value,
        onPlanetSelected = { planet ->
            navController.navigate("${DetailScreen.route}/$planet")
        }
    )
}