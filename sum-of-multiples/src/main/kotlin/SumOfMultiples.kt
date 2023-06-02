object SumOfMultiples {
    fun sum(factors: Set<Int>, limit: Int) =
        (1 until limit)
            .filter { factors.hasInt(it) }
            .sum()
    private fun Set<Int>.hasInt(n: Int) = any {
        it > 0 && n % it == 0
    }
}