package com.applications.calcfun.generator.domain.use_case

import com.applications.calcfun.generator.data.Expression
import com.applications.calcfun.generator.domain.api.GeneratorInteractor
import com.applications.calcfun.generator.domain.api.GeneratorRepository

class GeneratorInteractorImpl(private val generatorRepository: GeneratorRepository) :
    GeneratorInteractor {
    override fun createExpression(): Expression {
        return generatorRepository.createExpression()
    }
}