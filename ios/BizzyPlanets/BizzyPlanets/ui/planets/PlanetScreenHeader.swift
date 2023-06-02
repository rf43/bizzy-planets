import SwiftUI

struct PlanetScreenHeader: View {
    
    var headerTitle: String
    var headerSubtitle: String
    
    var body: some View {
        VStack {
            Text(headerTitle)
                .font(.system(size: 16.0))
                .fontWeight(.light)
            Text(headerSubtitle)
        }
    }
}

struct PlanetScreenHeader_Previews: PreviewProvider {
    static var previews: some View {
        PlanetScreenHeader(
            headerTitle: "Header Title",
            headerSubtitle: "header subtitle"
        )
    }
}
