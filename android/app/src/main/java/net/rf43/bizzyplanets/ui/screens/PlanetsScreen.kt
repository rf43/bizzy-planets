package net.rf43.bizzyplanets.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import net.rf43.bizzyplanets.R
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
        Text(text = "Planet Screen...")
        Spacer(modifier = Modifier.height(24.dp))
        LazyVerticalGrid(
            modifier = Modifier.width(330.dp),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(count = planetList.size) {
                Box(
                    modifier = Modifier
                        .size(164.dp)
                        .background(Color.Black)
                        .clickable {
                            onPlanetSelected(planetList[it].name)
                        }
                ) {
                    AsyncImage(
                        modifier = Modifier.fillMaxSize(),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(planetList[it].images.thumbnail)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        placeholder = painterResource(id = R.drawable.ic_android_black_48dp)
                    )
                    Text(
                        text = planetList[it].name,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxSize()
                    )
                }
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