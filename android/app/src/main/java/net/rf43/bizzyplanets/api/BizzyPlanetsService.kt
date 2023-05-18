package net.rf43.bizzyplanets.api

import net.rf43.bizzyplanets.data.models.PlanetsResponse
import retrofit2.Response
import retrofit2.http.GET

interface BizzyPlanetsService {

    @GET("${JSON_URL_PATH}planets.json")
    suspend fun planetsResponse(): Response<PlanetsResponse>
}