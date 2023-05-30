import SwiftUI

struct PlanetDetailContent: View {
    
    var planetDetail: PlanetModel
    
    var body: some View {
        ScrollView {
            VStack {
                // Text -> planet name
                Text(planetDetail.name)
                // Spacer
                Spacer().frame(maxHeight: 24)
                // Text -> Long description
                //         needs to be scrollable
                Text(planetDetail.longDescription.replacingOccurrences(of: "\n", with: "\n\n"))
            }
        }
    }
}

struct PlanetDetailContent_Previews: PreviewProvider {
    static var previews: some View {
        PlanetDetailContent(
            planetDetail: fakePlanetList[5]
        )
    }
}
