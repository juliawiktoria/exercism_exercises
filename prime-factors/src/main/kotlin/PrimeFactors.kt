object PrimeFactorCalculator {

    fun primeFactors(int: Int): List<Int> {
        val primeFactors = mutableListOf<Int>()
        var n = int
        var divisor = 2

        while (divisor <= n) {
            if (n % divisor == 0) {
                primeFactors.add(divisor)
                n /= divisor
            } else {
                divisor++
            }
        }

        return primeFactors
    }

    fun primeFactors(long: Long): List<Long> {
        val primeFactors = mutableListOf<Long>()
        var n = long
        var divisor = 2.toLong()

        while (divisor <= n) {
            if (n % divisor == 0.toLong()) {
                primeFactors.add(divisor)
                n /= divisor
            } else {
                divisor++
            }
        }

        return primeFactors
    }
}
