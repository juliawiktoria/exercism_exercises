class KindergartenGarden(private val diagram: String) {
    val firstRow: List<Char>
    val secondRow: List<Char>
    init {
        val (one, two) = diagram.split("\n")
        firstRow = one.toList()
        secondRow = two.toList()
    }
    fun getPlantsOfStudent(student: String): List<String> {
        val index = nameToIndex(student) * 2
        val first = firstRow.subList(index,index+2).map { letterToPlant(it) }
        val second = secondRow.subList(index,index+2).map { letterToPlant(it) }
        return first + second
    }
    private fun letterToPlant(ch: Char): String = when(ch) {
        'G' -> "grass"
        'C' -> "clover"
        'R' -> "radishes"
        'V' -> "violets"
        else -> "Unknown"
    }
    private fun nameToIndex(name: String): Int = when(name) {
        "Alice" -> 0
        "Bob" -> 1
        "Charlie" -> 2
        "David" -> 3
        "Eve" -> 4
        "Fred" -> 5
        "Ginny" -> 6
        "Harriet" -> 7
        "Ileana" -> 8
        "Joseph" -> 9
        "Kincaid" -> 10
        "Larry" -> 11
        else -> - 1
    }
}