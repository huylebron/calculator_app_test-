package net.braniumacademy.lesson412

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

// todo 6: create view model class
class CalculatorViewModel : ViewModel() {
    // todo 7: declare variables
    private val _expression = MutableLiveData<String>()
    private val expressionBuilder = StringBuilder()
    private val calculator: Calculator = CalculatorImp()
    private var operator = Operator.NONE

    // todo 8: define a variable public expression to UI via LiveData
    val expression: LiveData<String>
        get() = _expression

    // todo 9: define appendNumber() method
    fun appendNumber(number: Char) {
        if (expressionBuilder.length == 1 && expressionBuilder[0] == '0') {
            expressionBuilder.delete(0, 1)
        }
        expressionBuilder.append(number)
        _expression.value = expressionBuilder.toString()
    }

    // todo 10: define setOperator() method
    fun setOperator(op: Operator) {
        operator = op
    }

    // todo 11: define calculateAnswer() method
    fun calculateAnswer() {
        val operands = expressionBuilder.toString().split("[^0123456789.]".toRegex())
            .dropLastWhile { it.isEmpty() }
            .toTypedArray()
        val format = DecimalFormat("#,###.###")
        if (operands.size == 2) {
            val number1 = calculator.convertToNumber(operands[0])
            val number2 = calculator.convertToNumber(operands[1])
            var result = 0.0
            var error = false
            when (operator) {
                Operator.ADD -> result = calculator.add(number1, number2)
                Operator.SUB -> result = calculator.sub(number1, number2)
                Operator.MUL -> result = calculator.mul(number1, number2)
                Operator.DIV -> if (number2 == 0.0) {
                    error = true
                    _expression.setValue(Calculator.ERROR)
                } else {
                    result = calculator.div(number1, number2)
                }

                Operator.MOD -> if (number2 == 0.0) {
                    error = true
                    _expression.setValue(Calculator.ERROR)
                } else {
                    result = calculator.mod(number1, number2)
                }
                else -> {
                    result = _expression.value!!.toDouble()
                }
            }
            if (!error) {
                _expression.value = format.format(result)
            }
        }
    }

    // todo 12: define reset() method
    private fun reset() {
        expressionBuilder.append('0')
        _expression.value = expressionBuilder.toString()
    }

    // todo 13: define clear() method
    fun clear() {
        expressionBuilder.delete(0, expressionBuilder.length)
        reset()
    }

    fun changeSign() {
        if (expressionBuilder.elementAt(0) != '+' &&
            expressionBuilder.elementAt(0) != '-'
        ) {
            expressionBuilder.insert(0, '-')
        } else if (expressionBuilder.elementAt(0) == '+') {
            expressionBuilder.setCharAt(0, '-')
        } else if (expressionBuilder.elementAt(0) == '-') {
            expressionBuilder.setCharAt(0, '+')
        }
        _expression.value = expressionBuilder.toString()
    }
}