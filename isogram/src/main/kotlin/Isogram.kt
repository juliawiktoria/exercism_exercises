object Isogram {

    fun isIsogram(input: String): Boolean {
        return input.filter{ it.isLetter() }.toList().groupingBy { it.lowercase() }.eachCount().all { (_, count) -> count == 1 }
    }
}
