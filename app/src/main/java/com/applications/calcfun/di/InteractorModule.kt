package com.applications.calcfun.di

import com.applications.calcfun.generator.domain.api.GeneratorInteractor
import com.applications.calcfun.generator.domain.use_case.GeneratorInteractorImpl
import com.applications.calcfun.score.domain.api.ScoreInteractor
import com.applications.calcfun.score.domain.use_case.ScoreInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    single<GeneratorInteractor> {
        GeneratorInteractorImpl(get())
    }
    single<ScoreInteractor> {
        ScoreInteractorImpl(get())
    }
}