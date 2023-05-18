package net.rf43.bizzyplanets.data.models

data class PlanetModel(
    val name: String = "",
    val link: String = "",
    val quickDescription: String = "",
    val shortDescription: String = "",
    val longDescription: List<String> = emptyList(),
    val images: PlanetImagesModel = PlanetImagesModel()
)

data class PlanetImagesModel(
    val thumbnail: String = "",
    val hero: String = ""
)
