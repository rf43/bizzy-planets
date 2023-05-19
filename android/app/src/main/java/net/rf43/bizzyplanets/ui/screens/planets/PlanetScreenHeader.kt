package net.rf43.bizzyplanets.ui.screens.planets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.rf43.bizzyplanets.ui.theme.BizzyPlanetsTheme

@Composable
fun PlanetScreenHeader(title: String, subtitle: String) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = subtitle,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Light
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=311dp,height=991dp,orientation=portrait")
@Composable
private fun ScreenHeaderPreview() {
    BizzyPlanetsTheme {
        PlanetScreenHeader(
            title = "TITLE",
            subtitle = "Quis ipsum suspendisse ultrices gravida. Semper risus in hendrerit gravida. Amet est placerat in egestas erat imperdiet sed euismod. Tristique senectus et netus et malesuada. Habitasse platea dictumst vestibulum rhoncus."
        )
    }
}