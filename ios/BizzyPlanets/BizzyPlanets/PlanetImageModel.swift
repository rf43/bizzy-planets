import Foundation

class PlanetImageModel {
    var thumbnailUrl: String
    var heroUrl: String
        
    init(thumbnailUrl: String, heroUrl: String) {
        self.thumbnailUrl = thumbnailUrl
        self.heroUrl = heroUrl
    }
}
