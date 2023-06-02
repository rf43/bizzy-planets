import Foundation

class PlanetModel: ObservableObject, Identifiable, Hashable {
    
    let id: String = UUID().uuidString
    
    var name: String
    var link: String
    var quickDescription: String
    var shortDescription: String
    var longDescription: String
    var images: PlanetImageModel
    
    convenience init() {
        self.init(
            name: "",
            link: "",
            quickDescription: "",
            shortDescription: "",
            longDescription: "",
            images: PlanetImageModel(thumbnailUrl: "", heroUrl: "")
        )
    }
    
    init(name: String, link: String, quickDescription: String, shortDescription: String, longDescription: String, images: PlanetImageModel) {
        self.name = name
        self.link = link
        self.quickDescription = quickDescription
        self.shortDescription = shortDescription
        self.longDescription = longDescription
        self.images = images
    }
    
    func hash(into hasher: inout Hasher) {
        hasher.combine(name)
        hasher.combine(link)
        hasher.combine(quickDescription)
        hasher.combine(shortDescription)
        hasher.combine(longDescription)
    }
    
    static func == (lhs: PlanetModel, rhs: PlanetModel) -> Bool {
        if lhs.name != rhs.name {
            return false
        }
        if lhs.link != rhs.link {
            return false
        }
        if lhs.quickDescription != rhs.quickDescription {
            return false
        }
        if lhs.shortDescription != rhs.shortDescription {
            return false
        }
        if lhs.longDescription != rhs.longDescription {
            return false
        }        
        
        return true
    }
}
