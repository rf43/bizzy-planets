import Foundation

extension ResponseDto {
    func mapToResponseModel() -> ResponseModel {
        return ResponseModel(
            title: self.title ?? "",
            subtitle: self.subtitle ?? "",
            attribution: self.attribution?.mapToModel() ?? AttributionModel(),
            sun: self.sun?.mapToModel() ?? SunModel(),
            planets: self.planets?.mapToModel() ?? [PlanetModel]()
        )
    }
}

private extension AttributionDto {
    func mapToModel() -> AttributionModel {
        return AttributionModel()
    }
}

private extension SunDto {
    func mapToModel() -> SunModel {
        return SunModel()
    }
}

private extension PlanetDto {
    func mapToModel() -> PlanetModel {
        return PlanetModel(
            name: self.name ?? "",
            link: self.link ?? "",
            quickDescription: self.quickDescription ?? "",
            shortDescription: self.shortDescription ?? "",
            longDescription: self.longDescription ?? "",
            images: self.images?.mapToModel() ?? PlanetImageModel()
        )
    }
}

private extension PlanetImagesDto {
    func mapToModel() -> PlanetImageModel {
        return PlanetImageModel(
            thumbnailUrl: "https://rf43.github.io/bizzy-planets/assets/images/\(self.thumbnail ?? "")",
            heroUrl: "https://rf43.github.io/bizzy-planets/assets/images/\(self.hero ?? "")"
        )
    }
}

private extension Array where Element == PlanetDto {
    func mapToModel() -> [PlanetModel] {
        let modelList = self.filter {
            $0.name != nil
            && $0.link != nil
            && $0.quickDescription != nil
            && $0.shortDescription != nil
            && $0.longDescription != nil
            && $0.images != nil
        }
        .map{ (dto) -> PlanetModel in
            dto.mapToModel()
        }
        
        return modelList
    }
}
