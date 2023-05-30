
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {

    if (naturalNumber < 1) throw RuntimeException()

    val divisors = (1..naturalNumber - 1).filter { naturalNumber % it == 0 }.toMutableList()

    println(divisors)

    if (divisors.sum() == naturalNumber) return Classification.PERFECT
    if (divisors.sum() > naturalNumber) return Classification.ABUNDANT

    return Classification.DEFICIENT
}
