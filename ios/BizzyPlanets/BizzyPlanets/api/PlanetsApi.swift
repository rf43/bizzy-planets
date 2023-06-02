import Foundation
import UIKit

class PlanetsApi {
    private let baseUrl: URL = URL(string: "https://rf43.github.io")!
    
    func getResponse(isDebug: Bool) async throws -> ResponseModel {
        return try await getBizzyPlanetResponse().mapToResponseModel()
    }
    
    private func getBizzyPlanetResponse() async throws -> ResponseDto  {
        let url = baseUrl.appending(path: "bizzy-planets/assets/json/v1/planets.json")
        
        var request = URLRequest(url: url)
        request.setValue("application/json", forHTTPHeaderField: "Content-Type")
        
        let (data, _) = try await URLSession.shared.data(for: request)
        
        let decodedData = try JSONDecoder().decode(ResponseDto.self, from: data)
        
//        print(decodedData.description)
                
        return decodedData
    }
}
