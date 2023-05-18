package net.rf43.bizzyplanets.navigation.navhosts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import net.rf43.bizzyplanets.navigation.DetailScreen
import net.rf43.bizzyplanets.ui.screens.ScreensViewModel
import net.rf43.bizzyplanets.ui.screens.planets.PlanetsScreen

@Composable
fun PlanetsScreenNavHost(navController: NavController) {
    val viewModel: ScreensViewModel = hiltViewModel()
    var loaded: Boolean by rememberSaveable { mutableStateOf(false) }

    if (!loaded) {
        viewModel.initPlanets()
        loaded = true
    }

    PlanetsScreen(
        planetList = viewModel.allPlanetsStateFlow.collectAsState().value,
        onPlanetSelected = { planet ->
            navController.navigate("${DetailScreen.route}/$planet")
        }
    )
}