import SwiftUI
import Combine

extension ContentView {
    @MainActor class PlanetViewModel: ObservableObject {
        
        @Published private(set) var planetScreenHeaderTitle: String = "Bizzy Planets"
        @Published private(set) var planetScreenHeaderSubtitle: String = "Loading"
        @Published private(set) var planetModel: PlanetModel = PlanetModel()
        @Published private(set) var planets: [PlanetModel] = [PlanetModel]()
        
        private let planetsApi = PlanetsApi()
        
        func initPlanets() async {
            do {
                let response = try await planetsApi.getResponse(isDebug: false)
                planetScreenHeaderTitle = response.title
                planetScreenHeaderSubtitle = response.subtitle
                planets = response.planets
            } catch {
                // Do some stuff here...
            }
        }
    }
}
