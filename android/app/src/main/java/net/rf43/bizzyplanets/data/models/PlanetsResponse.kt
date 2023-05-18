package net.rf43.bizzyplanets.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlanetsResponse(

	@Json(name="planets")
	val planets: List<PlanetDTO?>? = null,

	@Json(name="attribution")
	val attribution: AttributionDTO? = null,

	@Json(name="sun")
	val sun: SunDTO? = null
)

@JsonClass(generateAdapter = true)
data class ImagesDTO(

	@Json(name="thumbnail")
	val thumbnail: String? = null,

	@Json(name="hero")
	val hero: String? = null
)

@JsonClass(generateAdapter = true)
data class AttributionDTO(

	@Json(name="overview-url")
	val overviewUrl: String? = null,

	@Json(name="name")
	val name: String? = null
)

@JsonClass(generateAdapter = true)
data class PlanetDTO(

	@Json(name="quick-description")
	val quickDescription: String? = null,

	@Json(name="images")
	val images: ImagesDTO? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="link")
	val link: String? = null,

	@Json(name="long-description")
	val longDescription: String? = null,

	@Json(name="short-description")
	val shortDescription: String? = null
)

@JsonClass(generateAdapter = true)
data class SunDTO(

	@Json(name="images")
	val images: ImagesDTO? = null
)
