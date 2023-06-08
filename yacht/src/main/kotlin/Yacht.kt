import YachtCategory.*
object Yacht {
    private fun scoreConditionFunc(category: YachtCategory)
            : Pair<(IntArray) -> Boolean, (IntArray) -> Int> =
        // pair of <func to check condition>, <func to calculate score>
        when (category) {
            YACHT -> Pair(
                { ints -> ints.all { it == ints[0] } },
                { _ -> 50 }
            )
            ONES, TWOS, THREES, FOURS, FIVES, SIXES -> Pair(
                { _ -> true },
                { ints -> ints.filter { it == category.ordinal }.sum() }
            )
            FULL_HOUSE -> Pair(
                { ints -> ints.groupBy { it }.values.map { it.size }.toSet() == setOf(2, 3) },
                IntArray::sum
            )
            FOUR_OF_A_KIND -> Pair(
                { ints -> ints.groupBy { it }.values.any { it.size >= 4 } },
                { ints -> ints.groupBy { it }.values.first { it.size >= 4 }.take(4).sum() }
            )
            LITTLE_STRAIGHT -> Pair(
                { ints -> ints.toSet() == setOf(1, 2, 3, 4, 5) },
                { _ -> 30 }
            )
            BIG_STRAIGHT -> Pair(
                { ints -> ints.toSet() == setOf(2, 3, 4, 5, 6) },
                { _ -> 30 }
            )
            CHOICE -> Pair(
                { _ -> true },
                IntArray::sum
            )
        }

    fun solve(category: YachtCategory, vararg dices: Int): Int =
        with(scoreConditionFunc(category)) { if (first(dices)) second(dices) else 0 }
}
