import Foundation

struct ResponseDto: Decodable, Equatable, CustomStringConvertible {
    var title: String?
    var subtitle: String?
    var attribution: AttributionDto?
    var sun: SunDto?
    var planets: [PlanetDto]?
    
    var description: String {
        """
        ResponseDto(
            title: \(title ?? ""),
            subtitle: \(subtitle ?? ""),
            attribution: \n    \(attribution?.description ?? ""),
            sun: \n    \(sun?.description ?? ""),
            planets: \n    \(planets?.description ?? ""),
        )
        """
    }
}

struct AttributionDto: Decodable, Equatable, CustomStringConvertible {
    var overviewUrl: String?
    var name: String?
    
    enum CodingKeys: String, CodingKey {
        case overviewUrl = "overview-url"
        case name
    }
    
    var description: String {
        """
        AttributionDto(
            overviewUrl: \(overviewUrl ?? ""),
            name: \(name ?? ""),
        )
        """
    }
}

struct SunDto: Decodable, Equatable, CustomStringConvertible {
    let images: SunImagesDto?
    
    init() {
        self.images = SunImagesDto()
    }
    
    var description: String {
        """
        SunDto(
            images: \(images?.description ?? "")
        )
        """
    }
}

struct SunImagesDto: Decodable, Equatable, CustomStringConvertible {
    let thumbnail: String?
    
    init() {
        self.thumbnail = ""
    }
    
    var description: String {
        """
        SunImageDto(
            thumbnail: \(thumbnail ?? "")
        )
        """
    }
}

struct PlanetDto: Decodable, Equatable, CustomStringConvertible {
    let name: String?
    let quickDescription: String?
    let shortDescription: String?
    let longDescription: String?
    let link: String?
    let images: PlanetImagesDto?
    
    enum CodingKeys: String, CodingKey {
        case name
        case quickDescription = "quick-description"
        case shortDescription = "short-description"
        case longDescription = "long-description"
        case link
        case images
    }
    
    init() {
        self.name = ""
        self.quickDescription = ""
        self.shortDescription = ""
        self.longDescription = ""
        self.link = ""
        self.images = PlanetImagesDto()
    }
    
    var description: String {
        """
        PlanetDto(
            name: \(name ?? ""),
            quickDescription: \(quickDescription ?? ""),
            shortDescription: \(shortDescription ?? ""),
            longDescription: \(longDescription ?? ""),
            link: \(link ?? ""),
            images: \(images?.description ?? "")
        )
        """
    }
}

struct PlanetImagesDto: Decodable, Equatable, CustomStringConvertible {
    let thumbnail: String?
    let hero: String?
    
    init() {
        self.thumbnail = ""
        self.hero = ""
    }
    
    var description: String {
        """
        PlanetImagesDto(
            thumbnail: \(thumbnail ?? ""),
            hero: \(hero ?? "")
        )
        """
    }
}
