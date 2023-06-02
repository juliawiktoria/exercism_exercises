object Series {
    fun slices(n: Int, s: String): List<List<Int>> {
        if (n > s.length || n < 1) {
            throw IllegalArgumentException()
        }
        val substrings = mutableListOf<List<Int>>()

        if (n > s.length) {
            return substrings
        }

        for (i in 0..s.length - n) {
            val substring = s.substring(i, i + n)
            val digits = substring.map { it.toString().toInt() }
            substrings.add(digits)
        }

        return substrings
    }
}
