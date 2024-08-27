package net.braniumacademy.lesson412

// todo 5: implements Calculator interface
class CalculatorImp : Calculator {
    override fun convertToNumber(numberStr: String): Double {
        return if (numberStr.isEmpty()) {
            0.0
        } else numberStr.toDouble()
    }

    override fun add(a: Double, b: Double): Double {
        return a + b
    }

    override fun sub(a: Double, b: Double): Double {
        return a - b
    }

    override fun div(a: Double, b: Double): Double {
        return a / b
    }

    override fun mul(a: Double, b: Double): Double {
        return a * b
    }

    override fun mod(a: Double, b: Double): Double {
        return a % b
    }
}
// todo 5 done