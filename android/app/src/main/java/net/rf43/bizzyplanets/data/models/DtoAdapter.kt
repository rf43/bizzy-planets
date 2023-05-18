package net.rf43.bizzyplanets.data.models

import net.rf43.bizzyplanets.api.BASE_IMAGE_URL

internal fun PlanetDTO?.adaptTo(): PlanetModel {
    return PlanetModel(
        name = this?.name ?: "",
        link = this?.link ?: "",
        quickDescription = this?.quickDescription ?: "",
        shortDescription = this?.shortDescription ?: "",
        longDescription = adaptLongDescription(this?.longDescription),
        images = this?.images.adaptTo()
    )
}

private fun adaptLongDescription(stringList: List<String?>?): List<String> {
    return stringList?.filterNotNull() ?: emptyList()
}

private fun ImagesDTO?.adaptTo(): PlanetImagesModel {
    var thumbnailUrl = ""
    var heroUrl = ""

    this?.thumbnail?.let {
        thumbnailUrl = "${BASE_IMAGE_URL}/$it"
    }

    this?.hero?.let {
        heroUrl = "${BASE_IMAGE_URL}/$it"
    }

    return PlanetImagesModel(
        thumbnail = thumbnailUrl,
        hero = heroUrl,
    )
}