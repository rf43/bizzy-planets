import SwiftUI

struct PlanetsScreen: View {
    @Environment(\.horizontalSizeClass) private var horizontalSizeClass
    @Environment(\.verticalSizeClass) private var verticalSizeClass
    @Environment(\.dynamicTypeSize) private var typeSize
    
    var planets: [PlanetModel] = [
        PlanetModel(name: "Mercury"),
        PlanetModel(name: "Venus"),
        PlanetModel(name: "Earth"),
        PlanetModel(name: "Mars"),
        PlanetModel(name: "Jupiter"),
        PlanetModel(name: "Saturn"),
        PlanetModel(name: "Uranus"),
        PlanetModel(name: "Neptune")
    ]
    
    var body: some View {
        PlanetsGridView(
            planets: planets
        )
    }
}

struct PlanetsScreen_Previews: PreviewProvider {
    static var previews: some View {
        PlanetsScreen()
    }
}
