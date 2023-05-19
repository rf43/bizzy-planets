package net.rf43.bizzyplanets.api

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.rf43.bizzyplanets.data.models.ContentModel
import net.rf43.bizzyplanets.data.models.adaptTo
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

internal const val JSON_URL_PATH = "assets/json/v1/"
internal const val IMAGE_URL_PATH = "assets/images/"

internal const val BASE_URL = "https://rf43.github.io/bizzy-planets/"
internal const val BASE_IMAGE_URL = BASE_URL + IMAGE_URL_PATH

interface BizzyPlanetsApi {

    suspend fun fetchContentData(): ContentModel
}

class BizzyPlanetsApiImpl @Inject constructor() : BizzyPlanetsApi {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    override suspend fun fetchContentData(): ContentModel {
        val result = retrofit.create(BizzyPlanetsService::class.java)
        val response = result.planetsResponse()
        var contentModel: ContentModel = ContentModel()

        if (response.isSuccessful) {
            response.body()?.let {
                contentModel = it.adaptTo()
            }
        }

        return contentModel
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class BizzyPlanetsApiModule {

    @Singleton
    @Binds
    abstract fun bindBizzyPlanetsApi(
        api: BizzyPlanetsApiImpl
    ): BizzyPlanetsApi
}