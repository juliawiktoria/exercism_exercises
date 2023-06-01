class Anagram (val word: String) {

    fun match(anagrams: Collection<String>): Set<String> {
        var comparison = this.word.lowercase()
        return anagrams.filter {
            it.lowercase().toList().groupingBy { it }.eachCount() == comparison.toList().groupingBy { it }.eachCount()
                    && it.lowercase() != comparison
        }.toSet()
    }
}
