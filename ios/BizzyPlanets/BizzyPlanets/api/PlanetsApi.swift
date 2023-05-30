import Foundation
import UIKit

class PlanetsApi {
    private let baseUrl: URL? = URL(string: "https://rf43.github.io")
    
    enum Result {
        struct Response {
            let body: String? = nil
            let responseCode: String? = nil
        }
        
        case Loading
        case Success(Response)
        case Failure(String)
    }
    
    func getResponse(isDebug: Bool, onResult: @escaping (Result) -> Void) async {
        
    }
}
