package net.rf43.bizzyplanets.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
            Text(
                text = planetDetail.name,
                color = Color.White
            )
        }

        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .weight(1f, true)
            .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = "Details: ${planetDetail.name}")
            Text(
                text = fakeText
            )
        }
    }
}

private val fakeText = """
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Congue nisi vitae suscipit tellus mauris. Tristique senectus et netus et malesuada fames. Vel pretium lectus quam id leo in vitae. Libero enim sed faucibus turpis in eu mi. Erat nam at lectus urna duis convallis. Egestas egestas fringilla phasellus faucibus scelerisque eleifend. Rhoncus dolor purus non enim. Pellentesque dignissim enim sit amet venenatis urna. Pharetra diam sit amet nisl suscipit adipiscing bibendum est ultricies.

                    Blandit cursus risus at ultrices. Nulla aliquet enim tortor at auctor urna nunc. Eu turpis egestas pretium aenean. Erat pellentesque adipiscing commodo elit. Elementum integer enim neque volutpat. Duis convallis convallis tellus id. Quis ipsum suspendisse ultrices gravida. Pellentesque eu tincidunt tortor aliquam nulla facilisi cras fermentum odio. Ultrices neque ornare aenean euismod. Faucibus purus in massa tempor. Enim diam vulputate ut pharetra sit amet. Purus sit amet volutpat consequat. Lacus suspendisse faucibus interdum posuere lorem ipsum. Odio facilisis mauris sit amet massa vitae tortor. Quis auctor elit sed vulputate mi sit amet mauris commodo. Massa id neque aliquam vestibulum morbi blandit. Fermentum dui faucibus in ornare quam viverra orci sagittis. Et netus et malesuada fames ac turpis egestas maecenas.

                    Sapien nec sagittis aliquam malesuada bibendum arcu. Odio ut enim blandit volutpat. Aliquam ut porttitor leo a diam sollicitudin tempor. Dictumst vestibulum rhoncus est pellentesque. Amet risus nullam eget felis eget. At erat pellentesque adipiscing commodo elit at imperdiet. Adipiscing commodo elit at imperdiet dui accumsan sit amet. Urna condimentum mattis pellentesque id nibh. Mattis rhoncus urna neque viverra. Sed augue lacus viverra vitae congue. Habitasse platea dictumst quisque sagittis purus sit amet volutpat consequat.

                    Sit amet nisl purus in mollis nunc sed. Gravida dictum fusce ut placerat orci nulla. Nunc id cursus metus aliquam eleifend mi in nulla posuere. Adipiscing tristique risus nec feugiat in. Ullamcorper malesuada proin libero nunc consequat. Egestas tellus rutrum tellus pellentesque eu tincidunt tortor aliquam nulla. Sapien nec sagittis aliquam malesuada. Neque sodales ut etiam sit amet nisl. Et tortor consequat id porta nibh venenatis cras sed. Morbi quis commodo odio aenean sed adipiscing diam. Tempus imperdiet nulla malesuada pellentesque elit eget gravida cum. Commodo ullamcorper a lacus vestibulum sed arcu. Fringilla urna porttitor rhoncus dolor. Diam donec adipiscing tristique risus nec feugiat. Auctor neque vitae tempus quam pellentesque nec nam aliquam.

                    Sed turpis tincidunt id aliquet. Commodo ullamcorper a lacus vestibulum sed arcu. Sed euismod nisi porta lorem mollis aliquam ut porttitor leo. Risus commodo viverra maecenas accumsan lacus vel facilisis volutpat. Dolor sit amet consectetur adipiscing elit ut. Nunc scelerisque viverra mauris in aliquam sem. Eu turpis egestas pretium aenean. Erat imperdiet sed euismod nisi porta lorem mollis aliquam ut. Praesent tristique magna sit amet purus gravida quis. Rhoncus aenean vel elit scelerisque. Velit euismod in pellentesque massa placerat. Nunc sed velit dignissim sodales ut. Neque ornare aenean euismod elementum nisi quis eleifend. Quis imperdiet massa tincidunt nunc. Lectus mauris ultrices eros in cursus turpis massa tincidunt. Cras ornare arcu dui vivamus arcu felis bibendum ut tristique. Eu ultrices vitae auctor eu augue ut lectus arcu. Ultrices mi tempus imperdiet nulla malesuada.
                """.trimIndent()

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