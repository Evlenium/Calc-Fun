package com.applications.calcfun.generator.domain.api

import com.applications.calcfun.generator.data.Expression

interface GeneratorRepository {
    fun createExpression():Expression
}