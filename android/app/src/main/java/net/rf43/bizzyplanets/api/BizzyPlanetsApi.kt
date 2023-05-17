package net.rf43.bizzyplanets.api

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import net.rf43.bizzyplanets.data.models.Planet
import javax.inject.Inject

interface BizzyPlanetsApi {

    suspend fun fetchAllPlanetData(): List<Planet>
}

class BizzyPlanetsApiImpl @Inject constructor() : BizzyPlanetsApi {

    override suspend fun fetchAllPlanetData(): List<Planet> {
        return TempApiData.planetList
    }
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class BizzyPlanetsApiModule {

    @Binds
    abstract fun bindBizzyPlanetsApiModule(
        api: BizzyPlanetsApiImpl
    ): BizzyPlanetsApi
}