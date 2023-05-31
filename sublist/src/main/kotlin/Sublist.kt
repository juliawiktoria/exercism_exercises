enum class Relationship {

    EQUAL, SUBLIST, SUPERLIST, UNEQUAL

}

fun <T> List<T>.relationshipTo(other: List<T>) =
    when {
        this == other -> Relationship.EQUAL
        isSublist(this, other) -> Relationship.SUBLIST
        isSublist(other, this) -> Relationship.SUPERLIST
        else -> Relationship.UNEQUAL
    }
fun <T> isSublist(xs: List<T>, ys: List<T>) =
    if (xs.size > ys.size) false
    else xs.isEmpty() || ys.windowed(xs.size).any { it == xs }