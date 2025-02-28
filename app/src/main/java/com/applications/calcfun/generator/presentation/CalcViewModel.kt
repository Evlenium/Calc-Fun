package com.applications.calcfun.generator.presentation

import androidx.lifecycle.ViewModel
import com.applications.calcfun.generator.domain.api.GeneratorInteractor
import com.applications.calcfun.score.domain.api.ScoreInteractor

class CalcViewModel(
    private val generatorInteractor: GeneratorInteractor,
    private val scoreInteractor: ScoreInteractor
) : ViewModel() {
    fun getExpression() =
        generatorInteractor.createExpression()

    fun addPoint() {
        scoreInteractor.addPoint()
    }
}