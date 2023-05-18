package net.rf43.bizzyplanets.navigation

interface BizzyPlanetsDestination {
    val route: String
}

object PlanetsScreen: BizzyPlanetsDestination {
    override val route: String = "planets_screen"
}

object DetailScreen: BizzyPlanetsDestination {
    override val route: String = "detail_screen"
}