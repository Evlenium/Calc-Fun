package com.applications.calcfun.generator.domain.api

import com.applications.calcfun.generator.data.Expression

interface GeneratorInteractor {
    fun createExpression(): Expression
}