import SwiftUI

struct ContentView: View {
    
    @StateObject private var viewModel = PlanetViewModel()
    @State private var navPath = NavigationPath()
    
    var body: some View {
        NavigationStack(path: $navPath) {
            PlanetsScreen(
                headerTitle: viewModel.planetScreenHeaderTitle,
                headerSubtitle: viewModel.planetScreenHeaderSubtitle,
                planets: viewModel.planets
            ) { planet in
                navPath.append(planet)
            }
            .navigationDestination(for: PlanetModel.self) { planet in
                PlanetDetailScreen(planet: planet)
            }
            .task {
                await viewModel.initPlanets()
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
