package net.rf43.bizzyplanets.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f, true)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            Text(
                text = "Details: ${planetDetail.name}",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = buildAnnotatedString {
                    append(planetDetail.longDescription)
                    addStyle(
                        ParagraphStyle(lineBreak = LineBreak.Paragraph),
                        planetDetail.longDescription.indexOf('\n'),
                        planetDetail.longDescription.length
                    )
                }
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
    name = "SomePlanet",
    longDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc eget lorem dolor sed viverra. Tincidunt dui ut ornare lectus sit amet est placerat in. Id nibh tortor id aliquet. Ultricies leo integer malesuada nunc vel. Ultrices gravida dictum fusce ut placerat orci nulla pellentesque dignissim. Sit amet mauris commodo quis imperdiet. Lacus sed turpis tincidunt id aliquet risus feugiat in ante. In hac habitasse platea dictumst quisque sagittis purus sit. Nisi quis eleifend quam adipiscing vitae. Aenean et tortor at risus viverra. Eget magna fermentum iaculis eu non diam. Proin sagittis nisl rhoncus mattis rhoncus urna neque. Leo a diam sollicitudin tempor id eu nisl nunc mi. Neque laoreet suspendisse interdum consectetur libero id. Sit amet commodo nulla facilisi. Enim ut sem viverra aliquet eget sit amet tellus. Eu mi bibendum neque egestas congue quisque egestas. Feugiat scelerisque varius morbi enim nunc faucibus. Et netus et malesuada fames ac turpis.\nTurpis egestas integer eget aliquet. Arcu cursus euismod quis viverra nibh. Quis ipsum suspendisse ultrices gravida. Semper risus in hendrerit gravida. Amet est placerat in egestas erat imperdiet sed euismod. Tristique senectus et netus et malesuada. Habitasse platea dictumst vestibulum rhoncus. Varius vel pharetra vel turpis nunc eget lorem dolor sed. Volutpat commodo sed egestas egestas fringilla. Scelerisque viverra mauris in aliquam sem. Est lorem ipsum dolor sit amet consectetur adipiscing elit. Feugiat nibh sed pulvinar proin gravida hendrerit. Tellus pellentesque eu tincidunt tortor. Quam lacus suspendisse faucibus interdum posuere. Curabitur gravida arcu ac tortor dignissim. Faucibus et molestie ac feugiat. Nisl pretium fusce id velit ut tortor pretium viverra suspendisse. Dui id ornare arcu odio ut sem nulla. Id leo in vitae turpis massa sed elementum tempus egestas. Ornare quam viverra orci sagittis eu volutpat odio facilisis.\nEnim sit amet venenatis urna cursus. Erat imperdiet sed euismod nisi porta lorem. Id venenatis a condimentum vitae. Eget dolor morbi non arcu risus quis varius quam quisque. Viverra accumsan in nisl nisi scelerisque. Posuere lorem ipsum dolor sit amet. Tempus egestas sed sed risus. Ultrices sagittis orci a scelerisque purus semper eget. Ornare lectus sit amet est. Suspendisse faucibus interdum posuere lorem ipsum dolor. Blandit libero volutpat sed cras ornare arcu dui vivamus.\nMolestie ac feugiat sed lectus vestibulum mattis ullamcorper velit sed. Id faucibus nisl tincidunt eget nullam non nisi est. Leo a diam sollicitudin tempor id. Eget aliquet nibh praesent tristique magna sit amet purus gravida. Massa sapien faucibus et molestie ac feugiat. Purus viverra accumsan in nisl nisi. Nullam vehicula ipsum a arcu cursus. Amet aliquam id diam maecenas ultricies mi eget mauris pharetra. Orci a scelerisque purus semper eget. Morbi quis commodo odio aenean sed adipiscing diam donec. Viverra nibh cras pulvinar mattis nunc sed blandit. Feugiat vivamus at augue eget arcu dictum varius. In arcu cursus euismod quis viverra nibh cras pulvinar. Aliquam nulla facilisi cras fermentum. Ullamcorper eget nulla facilisi etiam dignissim diam quis. Convallis tellus id interdum velit laoreet id. Sit amet consectetur adipiscing elit duis tristique sollicitudin nibh. Neque vitae tempus quam pellentesque nec nam aliquam. Diam in arcu cursus euismod quis viverra nibh cras.\nEu lobortis elementum nibh tellus molestie nunc non. Morbi leo urna molestie at elementum eu facilisis sed. Sollicitudin ac orci phasellus egestas tellus rutrum tellus pellentesque eu. Id nibh tortor id aliquet lectus. Faucibus et molestie ac feugiat sed lectus. Senectus et netus et malesuada fames ac. Sed viverra ipsum nunc aliquet bibendum. Nibh sit amet commodo nulla facilisi nullam. Dignissim suspendisse in est ante in nibh mauris. Id ornare arcu odio ut sem nulla pharetra diam. Sit amet tellus cras adipiscing enim eu turpis egestas pretium. Accumsan lacus vel facilisis volutpat est velit. Sollicitudin nibh sit amet commodo nulla facilisi nullam vehicula. Sit amet est placerat in egestas erat imperdiet sed. Nibh venenatis cras sed felis eget velit aliquet. Pretium nibh ipsum consequat nisl. Velit scelerisque in dictum non consectetur a. Augue eget arcu dictum varius. Auctor neque vitae tempus quam pellentesque nec nam. Accumsan tortor posuere ac ut consequat semper viverra nam."
)