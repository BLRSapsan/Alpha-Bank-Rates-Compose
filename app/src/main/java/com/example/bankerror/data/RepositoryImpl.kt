package com.example.bankerror.data

import com.example.bankerror.data.model.RateResponse
import com.example.bankerror.data.model.RatesResponse
import com.example.bankerror.domain.Repository
import com.example.bankerror.domain.model.Rate
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val dataSource: DataSource) : Repository {

    override suspend fun getRates(): RatesResponse {
        return dataSource.rateResponse()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryAbstract {

    @Binds
    abstract fun repositoryAbstract(repositoryImpl: RepositoryImpl): Repository
}

fun RateResponse.toDomain() = Rate(
    buyCode = buyCode,
    buyIso = buyIso,
    date = date,
    name = name,
    quantity = quantity,
    buyRate = buyRate,
    sellCode = sellCode,
    sellRate = sellRate,
    sellIso = sellIso
)