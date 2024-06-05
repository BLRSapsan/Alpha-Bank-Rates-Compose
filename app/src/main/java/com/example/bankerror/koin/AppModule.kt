package com.example.bankerror.koin

import com.example.bankerror.data.Api
import com.example.bankerror.domain.RatesAlphaBankVM
import com.example.bankerror.domain.Repository
import com.example.bankerror.data.RepositoryImpl
import com.example.bankerror.data.getApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {

    viewModel { RatesAlphaBankVM(get()) }
    single<Api> { getApi() }
    single<Repository> { RepositoryImpl(get()) }
}