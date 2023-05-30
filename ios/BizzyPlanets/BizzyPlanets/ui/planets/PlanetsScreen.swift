import SwiftUI

struct PlanetsScreen: View {
    @Environment(\.horizontalSizeClass) private var horizontalSizeClass
    @Environment(\.verticalSizeClass) private var verticalSizeClass
    @Environment(\.dynamicTypeSize) private var typeSize
    
    var headerTitle: String
    var headerSubtitle: String
    var onPlanetSelected: (PlanetModel) -> Void
    
    var body: some View {
        VStack {
            PlanetScreenHeader(
                headerTitle: self.headerTitle,
                headerSubtitle: self.headerSubtitle
            )
            PlanetsGridView(
                planets: fakePlanetList
            ) { planet in onPlanetSelected(planet)}
        }
    }
}

struct PlanetsScreen_Previews: PreviewProvider {
    static var previews: some View {
        PlanetsScreen(
            headerTitle: "HeaderTitle", headerSubtitle: "HeaderSubtitle"
        ) { _ in }
    }
}
