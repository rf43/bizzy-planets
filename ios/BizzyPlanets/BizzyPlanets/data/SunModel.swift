import Foundation

struct SunModel {
    let images: SunImagesModel
    
    init() {
        self.images = SunImagesModel()
    }
}

struct SunImagesModel {
    let thumbnail: String
    
    init() {
        self.thumbnail = ""
    }
}
