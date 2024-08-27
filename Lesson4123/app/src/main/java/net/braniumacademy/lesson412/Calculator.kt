package net.braniumacademy.lesson412

// todo 4: create calculator operators and constant
interface Calculator {
    fun convertToNumber(numberStr: String): Double
    fun add(a: Double, b: Double): Double
    fun sub(a: Double, b: Double): Double
    fun div(a: Double, b: Double): Double
    fun mul(a: Double, b: Double): Double
    fun mod(a: Double, b: Double): Double

    companion object {
        const val ERROR = "ERROR"
    }
}
// todo 4 done