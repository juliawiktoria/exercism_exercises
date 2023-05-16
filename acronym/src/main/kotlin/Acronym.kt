object Acronym {
    fun generate(phrase: String) : String {
        var words = phrase.split(" ", "-")
        val result = mutableListOf<Char>()

        for (w in words) {
            val adding = w.firstOrNull { it.isLetter() }
            if (adding !== null) result.add(adding)
        }
        return result.joinToString("").uppercase()
    }
}
