import SwiftUI
import Combine

extension ContentView {
    @MainActor class PlanetViewModel: ObservableObject {
        
        @Published private(set) var planetScreenHeaderTitle: String = "Planets"
        @Published private(set) var planetScreenHeaderSubtitle: String = ""
        @Published private(set) var planetModel: PlanetModel = PlanetModel()
        @Published private(set) var planets: [PlanetModel] = [PlanetModel]()
        
        private let planetsApi = PlanetsApi()
        
        
        func initPlanets() async {
            do {
                let response = try await planetsApi.getResponse(isDebug: false)
                planets = response.planets
                planetScreenHeaderTitle = response.title
                planetScreenHeaderSubtitle = response.subtitle
            } catch {
                // Do some stuff here...
            }
        }
        
        private func updateTitle(message: String) {
            self.planetScreenHeaderTitle = message
        }
        
        private func updateSubtitle(message: String) {
            DispatchQueue.main.async { [unowned self] in
                self.planetScreenHeaderSubtitle = message
            }
        }
        
        private func startPlanets(response: ResponseDto?) {
            guard let unwrappedResponse = response else {
                // No response so exit early
                return
            }
            
            guard let unwrappedPlanetList = unwrappedResponse.planets else {
                return
            }
            
            //            print(unwrappedResponse.description)
            print("YO YO YO!!!")
            print(unwrappedPlanetList)
            
            updateTitle(message: unwrappedResponse.title ?? "Planets")
            updateSubtitle(message: unwrappedResponse.subtitle ?? "Loading...")
            
            DispatchQueue.main.async {
                self.planets = fakePlanetList
            }
        }
    }
}
