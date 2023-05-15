package net.rf43.bizzyplanets.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.rf43.bizzyplanets.navigation.navhosts.PlanetsScreenNavHost

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

        composable(route = DetailScreen.route) {
            PlanetsScreenNavHost(navController = navController)
        }
    }
}