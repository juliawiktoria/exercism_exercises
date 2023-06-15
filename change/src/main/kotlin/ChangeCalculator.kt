class ChangeCalculator(val coins: List<Int>) {
    private val sortedCoins = coins.sorted()
    fun computeMostEfficientChange(total: Int): List<Int> {
        require(total >= 0) { "Negative totals are not allowed." }
        val changes = (1..total).fold(listOf<List<Int>?>(listOf<Int>())) { acc, amount ->
            coins
                .filter { acc.getOrNull(amount - it) != null }
                .map { listOf(it) + acc.get(amount - it)!! }
                .sortedBy { it.size }
                .firstOrNull()
                .let { acc.plusElement(it) }
        }
        return requireNotNull(changes.lastOrNull()) {
            "The total $total cannot be represented in the given currency."
        }
    }
}