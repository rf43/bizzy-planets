package net.rf43.bizzyplanets.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import net.rf43.bizzyplanets.ui.theme.BizzyPlanetsTheme

@Composable
fun PlanetsScreen(
    onPlanetSelected: (String) -> Unit
) {
    Text(text = "Planet Screen...")
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=511dp,height=991dp,orientation=portrait")
@Composable
fun PlanetsScreenPortraitPreview() {
    BizzyPlanetsTheme {
        PlanetsScreen {}
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=891dp,height=511dp,orientation=landscape")
@Composable
fun PlanetsScreenLandscapePreview() {
    BizzyPlanetsTheme {
        PlanetsScreen {}
    }
}