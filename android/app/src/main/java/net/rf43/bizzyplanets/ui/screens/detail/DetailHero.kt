package net.rf43.bizzyplanets.ui.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import net.rf43.bizzyplanets.R
import net.rf43.bizzyplanets.data.models.PlanetModel
import net.rf43.bizzyplanets.ui.theme.Black100Color
import net.rf43.bizzyplanets.ui.theme.Black25Color

@Composable
fun DetailHero(
    planetDetail: PlanetModel,
    onBackSelected: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(Color.Black)
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(planetDetail.images.hero)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.ic_android_black_48dp)
        )
        Column(
            Modifier
                .width(200.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Black100Color,
                            Black25Color
                        )
                    )
                )
                .align(Alignment.BottomStart)
                .padding(8.dp)
        ) {
            Text(
                text = planetDetail.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = planetDetail.shortDescription,
                fontSize = 10.sp,
                color = Color.White
            )
        }
        Image(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 8.dp, top = 8.dp)
                .clickable { onBackSelected() },
            painter = painterResource(id = R.drawable.baseline_arrow_back_24), contentDescription = "Navigate Back"
        )
    }
}