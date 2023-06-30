fun <T> List<T>.customAppend(list: List<T>): List<T> {
    return list.customFoldLeft(this) { newList, element -> newList + element }
}
fun List<Any>.customConcat(): List<Any> {
    return customFoldLeft(listOf()) { acc, element ->
        when (element) {
            is List<*> -> acc + (element as List<Any>).customConcat()
            else -> acc + element
        }
    }
}
fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
    return customFoldLeft(this) { newList, element ->
        if (predicate(element)) {
            newList
        } else newList - element
    }
}
val List<Any>.customSize: Int get() = this.customFoldLeft(0) { acc, _ -> acc + 1 }
fun <T, U> List<T>.customMap(transform: (T) -> U): List<U> {
    return customFoldLeft(listOf()) { newList, element -> newList + transform(element) }
}
fun <T, U> List<T>.customFoldLeft(initial: U, f: (U, T) -> U): U {
    if (this.isEmpty()) {
        return initial
    } else {
        return drop(1).customFoldLeft(f(initial, this.first()), f)
    }
}
fun <T, U> List<T>.customFoldRight(initial: U, f: (T, U) -> U): U {
    if (this.isEmpty()) {
        return initial
    } else {
        return f(this.first(), drop(1).customFoldRight(initial, f))
    }
}
fun <T> List<T>.customReverse(): List<T> {
    if (this.isEmpty()) {
        return emptyList()
    } else {
        val initial: List<T> = listOf()
        return customFoldLeft(initial) { newList, element -> listOf(element) + newList }
    }
}