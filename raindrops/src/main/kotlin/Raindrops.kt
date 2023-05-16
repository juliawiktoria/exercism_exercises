object Raindrops {

    fun convert(n: Int): String {
        val words = mutableListOf<String>()

        if (n % 3 == 0) words.add("Pling")

        if (n % 5 == 0) words.add("Plang")

        if (n % 7 == 0) words.add("Plong")

        if (words.size == 0) return n.toString()

        return words.joinToString("")
    }
}
