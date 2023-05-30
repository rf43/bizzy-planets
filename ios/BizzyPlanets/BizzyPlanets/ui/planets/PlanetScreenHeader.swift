import SwiftUI

struct PlanetScreenHeader: View {
    
    var headerTitle: String
    var headerSubtitle: String
    
    var body: some View {
        VStack {
            Text(headerTitle)
            Text(headerSubtitle)
        }
    }
}

struct PlanetScreenHeader_Previews: PreviewProvider {
    static var previews: some View {
        PlanetScreenHeader(
            headerTitle: "Header Title", headerSubtitle: "header subtitle"
        )
    }
}
