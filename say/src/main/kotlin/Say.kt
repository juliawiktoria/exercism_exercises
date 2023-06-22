class NumberSpeller {
    private val numbersToWords = mapOf(
        1L to "one", 2L to "two", 3L to "three", 4L to "four", 5L to "five", 6L to "six",
        7L to "seven", 8L to "eight", 9L to "nine", 10L to "ten", 11L to "eleven", 12L to "twelve", 13L to "thirteen",
        14L to "fourteen", 15L to "fifteen", 16L to "sixteen", 17L to "seventeen", 18L to "eighteen", 19L to "nineteen",
        20L to "twenty", 30L to "thirty", 40L to "forty", 50L to "fifty", 60L to "sixty", 70L to "seventy", 80L to "eighty",
        90L to "ninety", 100L to "hundred"
    )
    fun say(number: Long): String? {
        require(number >= 0) { "Input must be non-negative" }
        require(number < 1000000000000) { "Input must be less than 1000000000000" }
        if (number == 0L) return "zero"
        val chunks = number.chunksOfThousand()
        val scaledChunks = createScaledChunks(chunks)
        val individualChunks = createIndividualChunks(scaledChunks)
        return individualChunks.map {
            try {
                val num = it.trim().toLong()
                if (num >= 100) sayThreeDigitNumber(num) else sayTwoDigitNumber(num)
            } catch (e: NumberFormatException) {
                it
            }
        }.joinToString(separator = " ")
    }
    private fun createScaledChunks(chunks: List<Long>): List<String?> {
        return chunks.mapIndexed { idx, chunk ->
            val scale = when (idx) {
                1 -> "thousand"
                2 -> "million"
                3 -> "billion"
                else -> ""
            }
            if (chunk > 0) "$scale $chunk" else null
        }
    }
    private fun createIndividualChunks(scaledChunks: List<String?>) =
        scaledChunks.filterNotNull()
            .flatMap { it.split(" ") }
            .filter { !it.isEmpty() }
            .reversed()
    private fun sayThreeDigitNumber(number: Long): String? {
        val base = number / 100
        val remainer = number % 100
        return if (remainer > 0) {
            "${numbersToWords[base]} hundred ${sayTwoDigitNumber(remainer)}"
        } else {
            "${numbersToWords[base]} hundred"
        }
    }
    private fun sayTwoDigitNumber(number: Long): String? {
        if (number > 20) {
            val base = number / 10
            val remainer = number % 10
            return "${numbersToWords[base * 10]}-${numbersToWords[remainer]}"
        }
        return numbersToWords[number]
    }
    private fun Long.chunksOfThousand(): List<Long> {
        val chunks = mutableListOf<Long>()
        var current = this
        while (current >= 1000) {
            chunks.add(current % 1000)
            current /= 1000
        }
        chunks.add(current)
        return chunks
    }
}
