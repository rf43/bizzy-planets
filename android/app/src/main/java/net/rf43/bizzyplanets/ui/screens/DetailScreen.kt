package net.rf43.bizzyplanets.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import net.rf43.bizzyplanets.R
import net.rf43.bizzyplanets.data.models.PlanetModel
import net.rf43.bizzyplanets.ui.theme.BizzyPlanetsTheme

@Composable
fun DetailScreen(
    planetDetail: PlanetModel,
    onBackSelected: (String) -> Unit
) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.Black)
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(planetDetail.images.hero)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                placeholder = painterResource(id = R.drawable.ic_android_black_48dp)
            )
            Text(
                text = planetDetail.name,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=511dp,height=991dp,orientation=portrait")
@Composable
private fun DetailScreenPortraitPreview() {
    BizzyPlanetsTheme {
        DetailScreen(
            planetDetail = previewPlanetModel
        ) {}
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=891dp,height=511dp,orientation=landscape")
@Composable
private fun DetailScreenLandscapePreview() {
    BizzyPlanetsTheme {
        DetailScreen(
            planetDetail = previewPlanetModel
        ) {}
    }
}

private val previewPlanetModel = PlanetModel(
    name = "SomePlanet"
)