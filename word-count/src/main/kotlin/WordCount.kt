object WordCount {
    fun phrase(phrase: String): Map<String, Int> {
        val wordCounts = mutableMapOf<String, Int>()

        val words = phrase.split(Regex("[^\\w']+"))

        for (word in words) {
            val cleanedWord = word.trim('\'').toLowerCase()
            if (cleanedWord.isNotEmpty()) {
                wordCounts[cleanedWord] = wordCounts.getOrDefault(cleanedWord, 0) + 1
            }
        }

        return wordCounts
    }
}
