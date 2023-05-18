package net.rf43.bizzyplanets.api

import net.rf43.bizzyplanets.data.models.Planet

object TempApiData {
    val planetList: List<Planet> = listOf(
        Planet(
            name = "Mercury",
            thumbUrl = "https://rf43.github.io/bizzy-planets/assets/images/mercury_thumb.jpg",
            heroUrl = "https://rf43.github.io/bizzy-planets/assets/images/mercury_hero.jpg"
        ),
        Planet(
            name = "Venus",
            thumbUrl = "https://rf43.github.io/bizzy-planets/assets/images/venus_thumb.png",
            heroUrl = "https://rf43.github.io/bizzy-planets/assets/images/venus_hero.jpg"
        ),
        Planet(
            name = "Earth",
            thumbUrl = "https://rf43.github.io/bizzy-planets/assets/images/earth_thumb.jpg",
            heroUrl = "https://rf43.github.io/bizzy-planets/assets/images/earth_hero.jpg"
        ),
        Planet(
            name = "Mars",
            thumbUrl = "https://rf43.github.io/bizzy-planets/assets/images/mars_thumb.jpg",
            heroUrl = "https://rf43.github.io/bizzy-planets/assets/images/mars_hero.jpg"
        ),
        Planet(
            name = "Jupiter",
            thumbUrl = "https://rf43.github.io/bizzy-planets/assets/images/jupiter_thumb.jpg",
            heroUrl = "https://rf43.github.io/bizzy-planets/assets/images/jupiter_hero.jpg"
        ),
        Planet(
            name = "Saturn",
            thumbUrl = "https://rf43.github.io/bizzy-planets/assets/images/saturn_thumb.jpg",
            heroUrl = "https://rf43.github.io/bizzy-planets/assets/images/saturn_hero.jpg"
        ),
        Planet(
            name = "Uranus",
            thumbUrl = "https://rf43.github.io/bizzy-planets/assets/images/uranus_thumb.jpg",
            heroUrl = "https://rf43.github.io/bizzy-planets/assets/images/uranus_hero.jpg"
        ),
        Planet(
            name = "Neptune",
            thumbUrl = "https://rf43.github.io/bizzy-planets/assets/images/neptune_thumb.jpg",
            heroUrl = "https://rf43.github.io/bizzy-planets/assets/images/neptune_hero.jpg"
        )
    )
}