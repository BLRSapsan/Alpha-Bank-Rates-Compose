package com.example.bankerror.koin

import com.example.bankerror.data.Api
import com.example.bankerror.data.getApi
import org.koin.dsl.module

val DataModule = module {
    single <Api> { getApi() }
}