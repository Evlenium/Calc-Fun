package com.applications.calcfun.di

import com.applications.calcfun.generator.data.Generator
import com.applications.calcfun.generator.domain.api.GeneratorRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<GeneratorRepository> {
        Generator()
    }
}