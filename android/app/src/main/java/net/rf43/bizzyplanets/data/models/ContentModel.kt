package net.rf43.bizzyplanets.data.models

data class ContentModel(
    val title: String = "",
    val subtitle: String = "",
    val planets: List<PlanetModel> = emptyList()
)
