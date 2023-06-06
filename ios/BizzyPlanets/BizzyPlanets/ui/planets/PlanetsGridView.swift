import SwiftUI

struct PlanetsGridView: View {
    @Environment(\.horizontalSizeClass) private var horizontalSizeClass
    @Environment(\.verticalSizeClass) private var verticalSizeClass
    @Environment(\.dynamicTypeSize) private var typeSize
    
    var planets: [PlanetModel]
    
    var onPlanetSelected: (PlanetModel) -> Void
    
    var body: some View {
        
        // Externalizing the item size here so that we are able
        // to control the item size from out here in the event
        // each item needs to have a different size.
        //
        // An example of this might be where the items are in
        // scrolling list and as the user scrolls, each item
        // starts small, grows as the list is scrolled and
        // then shrinks in size as it approaches the top of
        // the list.
        let itemSize: CGFloat = 164.0
        
        
        // TODO: Refactor this to use LazyVGrid
        Grid(horizontalSpacing: 1, verticalSpacing: 1) {
            
            if planets.count == 0 {
                Text("nope...")
            } else {
                
                ForEach(0..<4) { i in
                    
                    let first = i * 2
                    let second = i * 2 + 1
                    
                    GridRow {
                        PlanetItemView(
                            planet: planets[first],
                            width: itemSize,
                            height: itemSize
                        ) { planet in onPlanetSelected(planet)}
                        PlanetItemView(
                            planet: planets[second],
                            width: itemSize,
                            height: itemSize
                        ) { planet in onPlanetSelected(planet)}
                    }
                }
            }
        }
    }
}

struct PlanetsGridView_Previews: PreviewProvider {
    static var previews: some View {
        PlanetsGridView(planets: fakePlanetList) { _ in }
    }
}
