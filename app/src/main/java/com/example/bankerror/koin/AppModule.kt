package com.example.bankerror.koin

//Retrofit
/*
import com.example.bankerror.data.retrofit.Api
import com.example.bankerror.domain.RatesAlphaBankVM
import com.example.bankerror.domain.Repository
import com.example.bankerror.data.RepositoryImpl
import com.example.bankerror.data.retrofit.getApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
    viewModel { RatesAlphaBankVM(get()) }
    single<Repository> { RepositoryImpl(get()) }
    single<Api> { getApi() }
}
*/

//Ktor
import com.example.bankerror.data.RepositoryImplKtor
import com.example.bankerror.data.ktor.KtorResponse
import com.example.bankerror.domain.RatesAlphaBankVM
import com.example.bankerror.domain.Repository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
    viewModel { RatesAlphaBankVM(get()) }
    single<Repository> { RepositoryImplKtor(get()) }
    single { KtorResponse() }
}
