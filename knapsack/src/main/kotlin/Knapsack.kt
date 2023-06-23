data class Item(val weight: Int, val value: Int)
fun knapsack(maximumWeight: Int, items: List<Item>): Int {
    fun addItem(currentWeight: Int, remainingItems: List<Item>, currentValue: Int): Int {
        val itemsThatFit = remainingItems.filter { it.weight <= maximumWeight - currentWeight }
        if (itemsThatFit.isEmpty() or (currentWeight >= maximumWeight)) {
            return currentValue
        }
        return itemsThatFit.maxOf {
            addItem(currentWeight.plus(it.weight), remainingItems.without(it),
                currentValue.plus(it.value))
        }
    }
    return addItem(0, items, 0)
}

fun <T> List<T>.without(item: T) =
    this.withoutMatching { it == item }

fun <T> List<T>.withoutMatching(predicate: (T) -> Boolean): List<T> {
    val first = this.firstOrNull() { predicate(it) }
    return this.filter { first !== it }
}
