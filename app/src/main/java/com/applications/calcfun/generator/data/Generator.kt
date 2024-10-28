package com.applications.calcfun.generator.data

class Generator {
    private fun createNumber(min: Int, max: Int) = (min..max).random()
    private fun createOperation() = Operation.entries.shuffled().first()
    fun createExpression(): Expression {
        val first = createNumber(1, 100)
        var second = createNumber(0, 100)
        return when (createOperation()) {
            Operation.PLUS -> Expression(
                expression = "$first + $second = ",
                firstNumber = first,
                secondNumber = second,
                result = first + second
            )

            Operation.MINUS -> {
                while (first < second) {
                    second = createNumber(0, 100)
                }
                Expression(
                    expression = "$first - $second = ",
                    firstNumber = first,
                    secondNumber = second,
                    result = first - second
                )
            }
        }
    }
}