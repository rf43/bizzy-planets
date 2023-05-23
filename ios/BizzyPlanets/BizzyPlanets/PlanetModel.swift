import Foundation

class PlanetModel: ObservableObject, Identifiable {
    let id: String = UUID().uuidString
    
    var name: String
    
    init() {
        name = ""
    }
    
    init(name: String) {
        self.name = name
    }
}
