package net.rf43.bizzyplanets.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.rf43.bizzyplanets.navigation.navhosts.DetailScreenNavHost
import net.rf43.bizzyplanets.navigation.navhosts.PlanetsScreenNavHost
import net.rf43.bizzyplanets.ui.screens.ScreensViewModel

private const val NAV_ARG_PLANET_NAME = "planetName"

@Composable
fun BizzyPlanetsNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = PlanetsScreen.route,
        modifier = modifier
    ) {
        composable(route = PlanetsScreen.route) {
            PlanetsScreenNavHost(navController = navController)
        }

        composable(
            route = "${DetailScreen.route}/{$NAV_ARG_PLANET_NAME}",
            arguments = listOf(
                navArgument(NAV_ARG_PLANET_NAME) {
                    type = NavType.StringType
                }
            )
        ) {
            val navArg = it.arguments?.getString(NAV_ARG_PLANET_NAME) ?: ""
            DetailScreenNavHost(
                navController = navController,
                planetName = navArg
            )
        }
    }
}