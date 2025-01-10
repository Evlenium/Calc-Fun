package com.applications.calcfun.generator.presentation

import androidx.lifecycle.ViewModel
import com.applications.calcfun.generator.domain.api.GeneratorInteractor

class CalcViewModel(private val generatorInteractor: GeneratorInteractor) : ViewModel() {
    fun getExpression() =
        generatorInteractor.createExpression()
}