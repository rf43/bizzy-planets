import SwiftUI

struct ContentView: View {
    
    @StateObject private var viewModel = PlanetViewModel()
    @State private var navPath = NavigationPath()
    
    var body: some View {
        NavigationStack(path: $navPath) {
            PlanetsScreen(
                headerTitle: viewModel.planetScreenHeaderTitle,
                headerSubtitle: viewModel.planetScreenHeaderSubtitle
            ) { planet in
                navPath.append(planet)
            }
            .navigationDestination(for: PlanetModel.self) { planet in
                PlanetDetailScreen(planet: planet)
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
