package com.applications.calcfun.di

import com.applications.calcfun.generator.domain.api.GeneratorInteractor
import com.applications.calcfun.generator.domain.use_case.GeneratorInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    single<GeneratorInteractor> {
        GeneratorInteractorImpl(get())
    }
}