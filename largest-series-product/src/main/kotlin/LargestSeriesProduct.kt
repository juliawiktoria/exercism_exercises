class Series(var word: String) {

    init {
        if (word.any { it.isLetter() }) throw IllegalArgumentException()
    }

    fun getLargestProduct(span: Int): Long {
        if (span > this.word.length || span < 1) throw IllegalArgumentException()
        return (this.word.windowed(span) { it.map(Character::getNumericValue).reduce(Int::times) }.maxOrNull() ?: 0).toLong()
    }
}
