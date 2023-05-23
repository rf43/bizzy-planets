import SwiftUI

struct PlanetsGridView: View {
    @Environment(\.horizontalSizeClass) private var horizontalSizeClass
    @Environment(\.verticalSizeClass) private var verticalSizeClass
    @Environment(\.dynamicTypeSize) private var typeSize
    
    var planets: [PlanetModel]
    
    var body: some View {
        
        let itemSize: CGFloat = 164.0
        
        Grid(horizontalSpacing: 1, verticalSpacing: 1) {
            ForEach(0..<4) { _ in
                GridRow {
                    PlanetItemView(
                        planet: planets[0],
                        width: itemSize,
                        height: itemSize
                    )
                    PlanetItemView(
                        planet: planets[1],
                        width: itemSize,
                        height: itemSize
                    )
                }
            }
        }
    }
}

struct PlanetsGridView_Previews: PreviewProvider {
    static var previews: some View {
        PlanetsGridView(
            planets: [
                PlanetModel(name: "Mercury"),
                PlanetModel(name: "Venus"),
                PlanetModel(name: "Earth"),
                PlanetModel(name: "Mars"),
                PlanetModel(name: "Jupiter"),
                PlanetModel(name: "Saturn"),
                PlanetModel(name: "Uranus"),
                PlanetModel(name: "Neptune")
            ]
        )
    }
}
