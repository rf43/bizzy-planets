import SwiftUI

struct PlanetDetailScreen: View {
    
    var planet: PlanetModel
    
    var body: some View {
        VStack {
            PlanetDetailHero(planetDetail: planet)
            PlanetDetailContent(planetDetail: planet)
        }
    }
}

struct PlanetDetailScreen_Previews: PreviewProvider {
    static var previews: some View {
        PlanetDetailScreen(planet: fakePlanetList[4])
    }
}
