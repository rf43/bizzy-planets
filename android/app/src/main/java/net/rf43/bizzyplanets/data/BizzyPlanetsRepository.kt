package net.rf43.bizzyplanets.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.rf43.bizzyplanets.api.BizzyPlanetsApi
import net.rf43.bizzyplanets.data.models.ContentModel
import net.rf43.bizzyplanets.data.models.PlanetModel
import javax.inject.Inject
import javax.inject.Singleton

interface BizzyPlanetsRepository {

    suspend fun fetchContentData()
    suspend fun fetchHomeTitle(): String
    suspend fun fetchHomeSubtitle(): String
    suspend fun fetchAllPlanets(): List<PlanetModel>
    suspend fun fetchPlanetDetails(name: String): PlanetModel
}

class BizzyPlanetsRepositoryImpl @Inject constructor(
    private val api: BizzyPlanetsApi
) : BizzyPlanetsRepository {

    private var contentModel: ContentModel = ContentModel()

    override suspend fun fetchContentData() {
        contentModel = api.fetchContentData()
    }

    override suspend fun fetchHomeTitle(): String {
        return contentModel.title
    }

    override suspend fun fetchHomeSubtitle(): String {
        return contentModel.subtitle
    }

    override suspend fun fetchAllPlanets(): List<PlanetModel> {
        return contentModel.planets
    }

    override suspend fun fetchPlanetDetails(name: String): PlanetModel {
        return contentModel.planets.firstOrNull {
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