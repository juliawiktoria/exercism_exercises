class Dna(string: String) {
    init { require(string.matches("[ACGT]*".toRegex())) { "Only A, C, G and T allowed in DNA string." } }
    val nucleotideCounts = ("ACGT" + string).groupBy { it }.mapValues { it.value.size - 1 }
}
