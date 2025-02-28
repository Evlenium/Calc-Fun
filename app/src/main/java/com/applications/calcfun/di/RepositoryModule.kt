package com.applications.calcfun.di

import android.content.SharedPreferences
import com.applications.calcfun.generator.data.Generator
import com.applications.calcfun.generator.domain.api.GeneratorRepository
import com.applications.calcfun.score.data.ScoreRepositoryImpl
import com.applications.calcfun.score.domain.api.ScoreRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val TOTAL_SCORE = "total_score"
val repositoryModule = module {
    single<GeneratorRepository> {
        Generator()
    }
    single<ScoreRepository> {
        val sharedScore: SharedPreferences by inject(qualifier = named(TOTAL_SCORE))
        ScoreRepositoryImpl(sharedScore)
    }
}