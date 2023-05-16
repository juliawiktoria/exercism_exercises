class Squares(number: Int) {

    val number: Int = number

    fun sumOfSquares(): Int {
        var result: Int = 0

        for (i in 1..this.number) {
            result = result + (i * i)
        }

        return result
    }

    fun squareOfSum(): Int {
        var sumOfNumbers = 0
        for (i in 1..this.number) {
            sumOfNumbers = sumOfNumbers + i
        }

        return sumOfNumbers * sumOfNumbers
    }

    fun difference(): Int {
        return this.squareOfSum() - this.sumOfSquares()
    }
}
