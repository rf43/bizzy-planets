package net.rf43.bizzyplanets.data

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.rf43.bizzyplanets.api.BizzyPlanetsApi
import net.rf43.bizzyplanets.data.models.PlanetModel
import javax.inject.Inject
import javax.inject.Singleton

interface BizzyPlanetsRepository {

    suspend fun fetchAllPlanets(): List<PlanetModel>
    suspend fun fetchPlanetDetails(name: String): PlanetModel
}

class BizzyPlanetsRepositoryImpl @Inject constructor(
    private val api: BizzyPlanetsApi
) : BizzyPlanetsRepository {

    init {
        Log.d("RF43", "init")
    }

    private val planetList: MutableList<PlanetModel> = mutableListOf()

    override suspend fun fetchAllPlanets(): List<PlanetModel> {
        planetList.addAll(api.fetchAllPlanetData())
        return planetList
    }

    override suspend fun fetchPlanetDetails(name: String): PlanetModel {
        // just fetchAllPlanets for now
        return planetList.firstOrNull {
            it.name == name
        } ?: PlanetModel()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class BizzyPlanetsRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindBizzyPlanetsRepository(
        impl: BizzyPlanetsRepositoryImpl
    ): BizzyPlanetsRepository
}