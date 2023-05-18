package net.rf43.bizzyplanets.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import net.rf43.bizzyplanets.api.BizzyPlanetsApi
import net.rf43.bizzyplanets.data.models.PlanetModel
import javax.inject.Inject

interface BizzyPlanetsRepository {

    suspend fun fetchAllPlanets(): List<PlanetModel>
    suspend fun fetchPlanetDetails(name: String): PlanetModel
}

class BizzyPlanetsRepositoryImpl @Inject constructor(
    private val api: BizzyPlanetsApi
) : BizzyPlanetsRepository {

    override suspend fun fetchAllPlanets(): List<PlanetModel> {
        return api.fetchAllPlanetData()
    }

    override suspend fun fetchPlanetDetails(name: String): PlanetModel {
        // just fetchAllPlanets for now
        return fetchAllPlanets().first {
            it.name == name
        }
    }
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class BizzyPlanetsRepositoryModule {

    @Binds
    abstract fun bindBizzyPlanetsRepositoryModule(
        impl: BizzyPlanetsRepositoryImpl
    ): BizzyPlanetsRepository
}