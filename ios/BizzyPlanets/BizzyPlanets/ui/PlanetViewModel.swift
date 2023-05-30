import SwiftUI
import Combine

extension ContentView {
    @MainActor class PlanetViewModel: ObservableObject {
        
        @Published private(set) var planetScreenHeaderTitle: String = "Planets"
        @Published private(set) var planetScreenHeaderSubtitle: String = "Loading..."
        @Published private(set) var planetModel: PlanetModel = fakePlanetList[0]
    }
}
