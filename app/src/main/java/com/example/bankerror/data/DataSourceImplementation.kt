package com.example.bankerror.data

import com.example.bankerror.data.model.RatesResponse
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton

class DataSourceImplementation @Inject constructor(private val apiService: APIService) :
    DataSource {
    override suspend fun rateResponse(): RatesResponse {
        return apiService.getRates()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceAbstract {
    @Binds
    abstract fun dataSourceAbstract(dataSourceImplementation: DataSourceImplementation): DataSource
}

interface APIService {
    @GET("partner/1.0.1/public/rates/")
    suspend fun getRates(): RatesResponse
}

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun provideBaseUrl(): String = "https://developerhub.alfabank.by:8273/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): APIService = retrofit.create(APIService::class.java)

}