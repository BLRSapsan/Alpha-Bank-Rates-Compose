package com.example.bankerror.koin

import com.example.bankerror.data.RepositoryImpl
import com.example.bankerror.data.DataSource
import com.example.bankerror.data.DataSourceImplementation
import com.example.bankerror.presentation.RatesAlphaBankVM
import com.example.bankerror.domain.Repository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
    viewModel { RatesAlphaBankVM(get()) }
    single<Repository> { RepositoryImpl(get()) }
    single<DataSource> { DataSourceImplementation(get()) }
}
