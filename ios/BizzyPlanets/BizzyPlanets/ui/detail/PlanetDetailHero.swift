import SwiftUI

struct PlanetDetailHero: View {
    
    var heroHeight: CGFloat = 250.0
    var planetDetail: PlanetModel
    
    var body: some View {
        GeometryReader { geometry in
            ZStack {
                // Hero image...
                AsyncImage(
                    url: URL(string: planetDetail.images.heroUrl),
                    content: { image in
                        image.resizable()
                            .aspectRatio(contentMode: .fill)
                    },
                    placeholder: {
                        ProgressView()
                    }
                )
            }
            .overlay(HeroEyebrowOverlay(planetDetail: self.planetDetail), alignment: .bottomLeading)
        }
        .frame(height: heroHeight)
    }
}

private struct HeroEyebrowOverlay: View {
    
    var planetDetail: PlanetModel
    
    var body: some View {
        VStack {
            Text(planetDetail.name)
                .frame(maxWidth: .infinity, alignment: .leading)
                .foregroundColor(Color.white)
                .font(.system(size: 18.0))
            Text(planetDetail.shortDescription)
                .frame(maxWidth: .infinity, alignment: .leading)
                .foregroundColor(Color.white)
                .font(.system(size: 10.0))
        }
        .frame(width: 200.0)
        .background(
            LinearGradient(
                gradient: Gradient(colors: [Color.eyebrowLeadingColor, Color.eyebrowTrailingColor]),
                startPoint: .leading,
                endPoint: .trailing
            )
        )
        .padding(8.0)
    }
}

struct PlanetDetailHero_Previews: PreviewProvider {
    static var previews: some View {
        PlanetDetailHero(
            planetDetail: fakePlanetList[3]
        )
        .border(Color.red)
        .background(Color.green)
    }
}
