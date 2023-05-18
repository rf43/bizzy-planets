package net.rf43.bizzyplanets.ui.screens.planets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.rf43.bizzyplanets.data.models.PlanetModel
import net.rf43.bizzyplanets.ui.theme.BizzyPlanetsTheme

@Composable
fun PlanetsScreen(
    planetList: List<PlanetModel> = emptyList(),
    onPlanetSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Planets")
        Text(text = "Four unique, rocky worlds, two complex gas giants and two distant ice giants.")
        Spacer(modifier = Modifier.height(24.dp))
        LazyVerticalGrid(
            modifier = Modifier.width(330.dp),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(count = planetList.size) {
                PlanetItemView(planet = planetList[it], onPlanetSelected)
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true, device = "spec:width=511dp,height=991dp,orientation=portrait")
@Composable
fun PlanetsScreenPortraitPreview() {
    BizzyPlanetsTheme {
        PlanetsScreen(
            planetList = listOf(
                PlanetModel(),
                PlanetModel(),
                PlanetModel(),
                PlanetModel(),
                PlanetModel(),
                PlanetModel()
            )
        ) {}
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=891dp,height=511dp,orientation=landscape")
@Composable
fun PlanetsScreenLandscapePreview() {
    BizzyPlanetsTheme {
        PlanetsScreen(
            planetList = listOf(
                PlanetModel(),
                PlanetModel(),
                PlanetModel(),
                PlanetModel(),
                PlanetModel(),
                PlanetModel()
            )
        ) {}
    }
}