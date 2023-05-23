import SwiftUI

struct PlanetItemView: View {
    @ObservedObject var planet: PlanetModel
    
    var width: CGFloat = 0.0
    var height: CGFloat = 0.0
    
    var onSelected: (PlanetModel) -> Void = { _ in }
    
    var body: some View {
        AsyncImage(
            url: URL(string: "https://rf43.github.io/bizzy-planets/assets/images/mercury_thumb.jpg"),
            content: { image in
                image.resizable()
                    .aspectRatio(contentMode: .fill)
            },
            placeholder: {
                ProgressView()
            }
        )
        .frame(width: width, height: height)
        .clipped()
        .overlay(PlanetNameOverlay(planetName: planet.name), alignment: .topLeading)
        .onTapGesture {
            onSelected(planet)
        }
    }
}

struct PlanetNameOverlay: View {
    var planetName: String
    
    var body: some View {
        ZStack {
            Text(planetName)
                .font(.headline)
                .padding(6)
                .foregroundColor(.white)
                
        }
        .background(Color.black.opacity(0.5))
        .cornerRadius(8.0)
        .padding(6)
    }
}

struct PlanetItemView_Previews: PreviewProvider {
    static var previews: some View {
        let itemSize: CGFloat = 164.0
        
        PlanetItemView(
            planet: PlanetModel(name: "PLANET"),
            width: itemSize,
            height: itemSize
        )
        .frame(width: itemSize, height: itemSize)
        .border(Color.red)
        .background(Color.green)
    }
}
