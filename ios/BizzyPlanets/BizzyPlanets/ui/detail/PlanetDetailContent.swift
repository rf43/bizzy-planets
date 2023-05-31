import SwiftUI

struct PlanetDetailContent: View {
    
    var planetDetail: PlanetModel
    
    var body: some View {
        ScrollView {
            VStack {
                Text("Details: \(planetDetail.name)")
                    .font(.system(size: 30.0))
                    .fontWeight(.heavy)
                Spacer().frame(maxHeight: 24)
                Text(planetDetail.longDescription.replacingOccurrences(of: "\n", with: "\n\n"))
                    .font(.system(size: 16.0))
                    .fontWeight(.light)
            }
            .padding([.top, .leading, .trailing], 16.0)
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
