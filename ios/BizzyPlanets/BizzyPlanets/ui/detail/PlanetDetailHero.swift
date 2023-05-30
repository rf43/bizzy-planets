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
            .clipped()
            .overlay(HeroEyebrowOverlay(planetDetail: self.planetDetail), alignment: .bottomLeading)
        }
        .frame(height: heroHeight)
    }
}

private struct HeroEyebrowOverlay: View {
    
    var planetDetail: PlanetModel
    
    var body: some View {
        VStack(alignment: .leading) {
            // Text -> Planet name
            Text(planetDetail.name).foregroundColor(Color.white)
            // Text -> Short description
            Text(planetDetail.shortDescription).foregroundColor(Color.white)
        }
        .border(Color.red)
        .background(Color.green)
    }
}

struct PlanetDetailHero_Previews: PreviewProvider {
    static var previews: some View {
        PlanetDetailHero(
            planetDetail: fakePlanetList[1]
        )
        .border(Color.red)
        .background(Color.green)
    }
}
