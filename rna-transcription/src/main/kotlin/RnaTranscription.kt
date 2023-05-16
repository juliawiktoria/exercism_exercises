fun transcribeToRna(dna: String): String {
    val dnaToRnaMap: Map<Char, Char> = mapOf(
        'G' to 'C',
        'C' to 'G',
        'T' to 'A',
        'A' to 'U'
    )

    return dna.map { dnaToRnaMap[it] }.joinToString("")
}
