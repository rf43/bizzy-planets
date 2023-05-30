import Foundation

let fakePlanetList: [PlanetModel] = [
    PlanetModel(
        name: "Mercury",
        link: "https://solarsystem.nasa.gov/planets/mercury/overview/",
        quickDescription: "Mercury-the smallest planet in our solar system and closest to the Sun—is only slightly larger than Earth's Moon. Mercury is the fastest planet, zipping around the Sun every 88 Earth days.",
        shortDescription: "From the surface of Mercury, the Sun would appear more than three times as large as it does when viewed from Earth, and the sunlight would be as much as 11 times brighter.",
        longDescription: "The smallest planet in our solar system and nearest to the Sun, Mercury is only slightly larger than Earth's Moon.\nFrom the surface of Mercury, the Sun would appear more than three times as large as it does when viewed from Earth, and the sunlight would be as much as seven times brighter. Despite its proximity to the Sun, Mercury is not the hottest planet in our solar system - that title belongs to nearby Venus, thanks to its dense atmosphere.\nBecause of Mercury's elliptical - egg-shaped - orbit, and sluggish rotation, the Sun appears to rise briefly, set, and rise again from some parts of the planet's surface. The same thing happens in reverse at sunset.",
        images: PlanetImageModel(
            thumbnailUrl: "https://rf43.github.io/bizzy-planets/assets/images/mercury_thumb.jpg",
            heroUrl: "https://rf43.github.io/bizzy-planets/assets/images/mercury_hero.jpg"
        )
    ),
    PlanetModel (
        name: "Venus",
        link: "https://solarsystem.nasa.gov/planets/venus/overview/",
        quickDescription: "A quick description",
        shortDescription: "A short description",
        longDescription: fakeLongDescription,
        images: PlanetImageModel(
            thumbnailUrl: "https://rf43.github.io/bizzy-planets/assets/images/venus_thumb.png",
            heroUrl: "https://rf43.github.io/bizzy-planets/assets/images/venus_hero.jpg"
        )
    ),
    PlanetModel (
        name: "Earth",
        link: "https://solarsystem.nasa.gov/planets/earth/overview/",
        quickDescription: "A quick description",
        shortDescription: "A short description",
        longDescription: fakeLongDescription,
        images: PlanetImageModel(
            thumbnailUrl: "https://rf43.github.io/bizzy-planets/assets/images/earth_thumb.jpg",
            heroUrl: "https://rf43.github.io/bizzy-planets/assets/images/earth_hero.jpg"
        )
    ),
    PlanetModel (
        name: "Mars",
        link: "https://solarsystem.nasa.gov/planets/mars/overview/",
        quickDescription: "A quick description",
        shortDescription: "A short description",
        longDescription: fakeLongDescription,
        images: PlanetImageModel(
            thumbnailUrl: "https://rf43.github.io/bizzy-planets/assets/images/mars_thumb.jpg",
            heroUrl: "https://rf43.github.io/bizzy-planets/assets/images/mars_hero.jpg"
        )
    ),
    PlanetModel (
        name: "Jupiter",
        link: "https://solarsystem.nasa.gov/planets/jupiter/overview/",
        quickDescription: "A quick description",
        shortDescription: "A short description",
        longDescription: fakeLongDescription,
        images: PlanetImageModel(
            thumbnailUrl: "https://rf43.github.io/bizzy-planets/assets/images/jupiter_thumb.jpg",
            heroUrl: "https://rf43.github.io/bizzy-planets/assets/images/jupiter_hero.jpg"
        )
    ),
    PlanetModel(
        name: "Saturn",
        link: "https://solarsystem.nasa.gov/planets/saturn/overview/",
        quickDescription: "A quick description",
        shortDescription: "A short description",
        longDescription: fakeLongDescription,
        images: PlanetImageModel(
            thumbnailUrl: "https://rf43.github.io/bizzy-planets/assets/images/saturn_thumb.jpg",
            heroUrl: "https://rf43.github.io/bizzy-planets/assets/images/saturn_hero.jpg"
        )
    ),
    PlanetModel(
        name: "Uranus",
        link: "https://solarsystem.nasa.gov/planets/uranus/overview/",
        quickDescription: "A quick description",
        shortDescription: "A short description",
        longDescription: fakeLongDescription,
        images: PlanetImageModel(
            thumbnailUrl: "https://rf43.github.io/bizzy-planets/assets/images/uranus_thumb.jpg",
            heroUrl: "https://rf43.github.io/bizzy-planets/assets/images/uranus_hero.jpg"
        )
    ),
    PlanetModel(
        name: "Neptune",
        link: "https://solarsystem.nasa.gov/planets/neptune/overview/",
        quickDescription: "A quick description",
        shortDescription: "A short description",
        longDescription: fakeLongDescription,
        images: PlanetImageModel(
            thumbnailUrl: "https://rf43.github.io/bizzy-planets/assets/images/neptune_thumb.jpg",
            heroUrl: "https://rf43.github.io/bizzy-planets/assets/images/neptune_hero.jpg"
        )
    )
]

private let fakeLongDescription = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.\nNeque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?\nAt vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat."
