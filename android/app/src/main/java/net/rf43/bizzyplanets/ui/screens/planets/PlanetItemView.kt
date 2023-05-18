package net.rf43.bizzyplanets.ui.screens.planets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import net.rf43.bizzyplanets.R
import net.rf43.bizzyplanets.data.models.PlanetModel

@Composable
fun PlanetItemView(
    planet: PlanetModel,
    onPlanetSelected: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .size(164.dp)
            .background(Color.Black)
            .clickable {
                onPlanetSelected(planet.name)
            }
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(planet.images.thumbnail)
                .crossfade(true)
                .build(),
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.ic_android_black_48dp)
        )
        Text(
            text = planet.name,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxSize()
        )
    }
}