object ArmstrongNumber {

    fun check(input: Int): Boolean {
        val digits = input.toString().map { it.toString().toDouble() }
        val power: Double = input.toString().length.toDouble()
        var result: Double = 0.0

        digits.forEach { d ->
            (result + Math.pow(d, power)).also { result = it }
        }

        return result == input.toDouble()
    }

}
