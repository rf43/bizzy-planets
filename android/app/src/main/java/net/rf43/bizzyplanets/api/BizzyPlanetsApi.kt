package net.rf43.bizzyplanets.api

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import net.rf43.bizzyplanets.data.models.PlanetModel
import net.rf43.bizzyplanets.data.models.PlanetsResponse
import net.rf43.bizzyplanets.data.models.adaptTo
import javax.inject.Inject

private const val JSON_URL_PATH = "/assets/json/v1/"
private const val IMAGE_URL_PATH = "/assets/images/"

internal const val BASE_URL = "https://rf43.github.io/bizzy-planets"
internal const val BASE_JSON_URL = BASE_URL + JSON_URL_PATH
internal const val BASE_IMAGE_URL = BASE_URL + IMAGE_URL_PATH

interface BizzyPlanetsApi {

    suspend fun fetchAllPlanetData(): List<PlanetModel>
}

class BizzyPlanetsApiImpl @Inject constructor() : BizzyPlanetsApi {

    override suspend fun fetchAllPlanetData(): List<PlanetModel> {
        val moshi: Moshi = Moshi.Builder().build()
        val jsonAdapter: JsonAdapter<PlanetsResponse> = moshi.adapter(PlanetsResponse::class.java)
        val tempResponseFromJson = jsonAdapter.fromJson(tempResponse)

        return tempResponseFromJson?.planets?.map {
            it.adaptTo()
        } ?: emptyList()
    }
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class BizzyPlanetsApiModule {

    @Binds
    abstract fun bindBizzyPlanetsApiModule(
        api: BizzyPlanetsApiImpl
    ): BizzyPlanetsApi
}

private val tempResponse: String = """
    {
        "attribution": {
            "overview-url": "https://solarsystem.nasa.gov/planets/overview/",
            "name": "Planetary Science Communications team at NASA's Jet Propulsion Laboratory for NASA's Science Mission Directorate."
        },
        "sun": {
            "images": {
                "thumbnail": "sun_with_flares.jpg"
            }
        },
        "planets": [
            {
                "name": "Mercury",
                "quick-description": "Mercury-the smallest planet in our solar system and closest to the Sun—is only slightly larger than Earth's Moon. Mercury is the fastest planet, zipping around the Sun every 88 Earth days.",
                "short-description": "From the surface of Mercury, the Sun would appear more than three times as large as it does when viewed from Earth, and the sunlight would be as much as 11 times brighter.",
                "long-description": [
                    "The smallest planet in our solar system and nearest to the Sun, Mercury is only slightly larger than Earth's Moon.",
                    "From the surface of Mercury, the Sun would appear more than three times as large as it does when viewed from Earth, and the sunlight would be as much as seven times brighter. Despite its proximity to the Sun, Mercury is not the hottest planet in our solar system - that title belongs to nearby Venus, thanks to its dense atmosphere.",
                    "Because of Mercury's elliptical - egg-shaped - orbit, and sluggish rotation, the Sun appears to rise briefly, set, and rise again from some parts of the planet's surface. The same thing happens in reverse at sunset."
                ],
                "link": "https://solarsystem.nasa.gov/planets/mercury/overview/",
                "images": {
                    "thumbnail": "mercury_thumb.jpg",
                    "hero": "mercury_hero.jpg"
                }
            },
            {
                "name": "Venus",
                "quick-description": "Venus spins slowly in the opposite direction from most planets. A thick atmosphere traps heat in a runaway greenhouse effect, making it the hottest planet in our solar system.",
                "short-description": "Similar in structure and size to Earth, Venus's thick atmosphere traps heat in a runaway greenhouse effect, making it the hottest planet in our solar system.",
                "long-description": [
                    "Venus is the second planet from the Sun and is Earth's closest planetary neighbor. It's one of the four inner, terrestrial (or rocky) planets, and it's often called Earth's twin because it's similar in size and density. These are not identical twins, however - there are radical differences between the two worlds.",
                    "Venus has a thick, toxic atmosphere filled with carbon dioxide and it's perpetually shrouded in thick, yellowish clouds of sulfuric acid that trap heat, causing a runaway greenhouse effect. It's the hottest planet in our solar system, even though Mercury is closer to the Sun. Surface temperatures on Venus are about 900 degrees Fahrenheit (475 degrees Celsius) - hot enough to melt lead. The surface is a rusty color and it's peppered with intensely crunched mountains and thousands of large volcanoes. Scientists think it's possible some volcanoes are still active.",
                    "Venus has crushing air pressure at its surface - more than 90 times that of Earth - similar to the pressure you'd encounter a mile below the ocean on Earth.",
                    "Another big difference from Earth - Venus rotates on its axis backward, compared to most of the other planets in the solar system. This means that, on Venus, the Sun rises in the west and sets in the east, opposite to what we experience on Earth. (It's not the only planet in our solar system with such an oddball rotation - Uranus spins on its side.)",
                    "Venus was the first planet to be explored by a spacecraft - NASA's Mariner 2 successfully flew by and scanned the cloud-covered world on Dec. 14, 1962. Since then, numerous spacecraft from the U.S. and other space agencies have explored Venus, including NASA's Magellan, which mapped the planet's surface with radar. Soviet spacecraft made the most successful landings on the surface of Venus to date, but they didn't survive long due to the extreme heat and crushing pressure. An American probe, one of NASA's Pioneer Venus Multiprobes, survived for about an hour after impacting the surface in 1978.",
                    "More recent Venus missions include ESA's Venus Express (which orbited from 2006 until 2016) and Japan's Akatsuki Venus Climate Orbiter (orbiting since 2016).",
                    "NASA's Parker Solar Probe has made multiple flybys of Venus. On Feb. 9, 2022, NASA announced the spacecraft had captured its first visible light images of the surface of Venus from space during its February 2021 flyby."
                ],
                "link": "https://solarsystem.nasa.gov/planets/venus/overview/",
                "images": {
                    "thumbnail": "venus_thumb.png",
                    "hero": "venus_hero.jpg"
                }
            },
            {
                "name": "Earth",
                "quick-description": "Earth—our home planet—is the only place we know of so far that's inhabited by living things. It's also the only planet in our solar system with liquid water on the surface.",
                "short-description": "Earth—our home planet—is the only place we know of so far that's inhabited by living things. It's also the only planet in our solar system with liquid water on the surface.",
                "long-description": [
                    "Our home planet is the third planet from the Sun, and the only place we know of so far that's inhabited by living things.",
                    "While Earth is only the fifth largest planet in the solar system, it is the only world in our solar system with liquid water on the surface. Just slightly larger than nearby Venus, Earth is the biggest of the four planets closest to the Sun, all of which are made of rock and metal.",
                    "The name Earth is at least 1,000 years old. All of the planets, except for Earth, were named after Greek and Roman gods and goddesses. However, the name Earth is a Germanic word, which simply means \"the ground.\""
                ],
                "link": "https://solarsystem.nasa.gov/planets/earth/overview/",
                "images": {
                    "thumbnail": "earth_thumb.jpg",
                    "hero": "earth_hero.jpg"
                }
            },
            {
                "name": "Mars",
                "quick-description": "Mars is a dusty, cold, desert world with a very thin atmosphere. There is strong evidence Mars was - billions of years ago - wetter and warmer, with a thicker atmosphere.",
                "short-description": "Mars is a dusty, cold, desert world with a very thin atmosphere. There is strong evidence Mars was - billions of years ago - wetter and warmer, with a thicker atmosphere.",
                "long-description": [
                    "Mars is the fourth planet from the Sun - a dusty, cold, desert world with a very thin atmosphere. Mars is also a dynamic planet with seasons, polar ice caps, canyons, extinct volcanoes, and evidence that it was even more active in the past.",
                    "Mars is one of the most explored bodies in our solar system, and it's the only planet where we've sent rovers to roam the alien landscape.",
                    "NASA currently has two rovers (Curiosity and Perseverance), one lander (InSight), and one helicopter (Ingenuity) exploring the surface of Mars.",
                    "Perseverance rover - the largest, most advanced rover NASA has sent to another world - touched down on Mars on Feb. 18, 2021, after a 203-day journey traversing 293 million miles (472 million kilometers). The Ingenuity helicopter rode to Mars attached to the belly of Perseverance.",
                    "Perseverance is one of three spacecraft that arrived at Mars in 2021. The Hope orbiter from the United Arab Emirates arrived on Feb. 9, 2021. China's Tianwen-1 mission arrived on Feb. 10, 2021, and includes an orbiter, a lander, and a rover. Europe and India also have spacecraft studying Mars from orbit.",
                    "In May 2021, China became the second nation to ever land successfully on Mars when its Zhurong Mars rover touched down.",
                    "An international fleet of eight orbiters is studying the Red Planet from above including three NASA orbiters: 2001 Mars Odyssey, Mars Reconnaissance Orbiter, and MAVEN.",
                    "These robotic explorers have found lots of evidence that Mars was much wetter and warmer, with a thicker atmosphere, billions of years ago."
                ],
                "link": "https://solarsystem.nasa.gov/planets/mars/overview/",
                "images": {
                    "thumbnail": "mars_thumb.jpg",
                    "hero": "mars_hero.jpg"
                }
            },
            {
                "name": "Jupiter",
                "quick-description": "Jupiter is more than twice as massive than the other planets of our solar system combined. The giant planet's Great Red spot is a centuries-old storm bigger than Earth.",
                "short-description": "Jupiter is more than twice as massive than the other planets of our solar system combined. The giant planet's Great Red Spot is a centuries-old storm bigger than Earth.",
                "long-description": [
                    "Jupiter has a long history of surprising scientists - all the way back to 1610 when Galileo Galilei found the first moons beyond Earth. That discovery changed the way we see the universe.",
                    "Fifth in line from the Sun, Jupiter is, by far, the largest planet in the solar system - more than twice as massive as all the other planets combined.",
                    "Jupiter's familiar stripes and swirls are actually cold, windy clouds of ammonia and water, floating in an atmosphere of hydrogen and helium. Jupiter's iconic Great Red Spot is a giant storm bigger than Earth that has raged for hundreds of years.",
                    "One spacecraft - NASA's Juno orbiter - is currently exploring this giant world."
                ],
                "link": "https://solarsystem.nasa.gov/planets/jupiter/overview/",
                "images": {
                    "thumbnail": "jupiter_thumb.jpg",
                    "hero": "jupiter_hero.jpg"
                }
            },
            {
                "name": "Saturn",
                "quick-description": "Adorned with a dazzling, complex system of icy rings, Saturn is unique in our solar system. The other giant planets have rings, but none are as spectacular as Saturn's. ",
                "short-description": "Adorned with a dazzling, complex system of icy rings, Saturn is unique in our solar system. The other giant planets have rings, but none are as spectacular as Saturn's.",
                "long-description": [
                    "Saturn is the sixth planet from the Sun and the second-largest planet in our solar system.",
                    "Adorned with thousands of beautiful ringlets, Saturn is unique among the planets. It is not the only planet to have rings - made of chunks of ice and rock - but none are as spectacular or as complicated as Saturn's.",
                    "Like fellow gas giant Jupiter, Saturn is a massive ball made mostly of hydrogen and helium."
                ],
                "link": "https://solarsystem.nasa.gov/planets/saturn/overview/",
                "images": {
                    "thumbnail": "saturn_thumb.jpg",
                    "hero": "saturn_hero.jpg"
                }
            },
            {
                "name": "Uranus",
                "quick-description": "Uranus-seventh planet from the Sun—rotates at a nearly 90-degree angle from the plane of its orbit. This unique tilt makes Uranus appear to spin on its side.",
                "short-description": "Uranus-seventh planet from the Sun—rotates at a nearly 90-degree angle from the plane of its orbit. This unique tilt makes Uranus appear to spin on its side.",
                "long-description": [
                    "Uranus is the seventh planet from the Sun, and has the third-largest diameter in our solar system. It was the first planet found with the aid of a telescope, Uranus was discovered in 1781 by astronomer William Herschel, although he originally thought it was either a comet or a star.",
                    "It was two years later that the object was universally accepted as a new planet, in part because of observations by astronomer Johann Elert Bode. Herschel tried unsuccessfully to name his discovery Georgium Sidus after King George III. Instead, the scientific community accepted Bode's suggestion to name it Uranus, the Greek god of the sky, as suggested by Bode."
                ],
                "link": "https://solarsystem.nasa.gov/planets/uranus/overview/",
                "images": {
                    "thumbnail": "uranus_thumb.jpg",
                    "hero": "uranus_hero.jpg"
                }
            },
            {
                "name": "Neptune",
                "quick-description": "Neptune-the eighth and most distant major planet orbiting our Sun-is dark, cold and whipped by supersonic winds. It was the first planet located through mathematical calculations.",
                "short-description": "Neptune-the eighth and most distant major planet orbiting our Sun-is dark, cold and whipped by supersonic winds. It was the first planet located through mathematical calculations.",
                "long-description": [
                    "Dark, cold, and whipped by supersonic winds, ice giant Neptune is the eighth and most distant planet in our solar system.",
                    "More than 30 times as far from the Sun as Earth, Neptune is the only planet in our solar system not visible to the naked eye and the first predicted by mathematics before its discovery. In 2011 Neptune completed its first 165-year orbit since its discovery in 1846.",
                    "NASA's Voyager 2 is the only spacecraft to have visited Neptune up close. It flew past in 1989 on its way out of the solar system."
                ],
                "link": "https://solarsystem.nasa.gov/planets/neptune/overview/",
                "images": {
                    "thumbnail": "neptune_thumb.jpg",
                    "hero": "neptune_hero.jpg"
                }
            }
        ]
    }
""".trimIndent()