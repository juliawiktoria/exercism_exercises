object RomanNumerals {

    fun value(n: Int): String {
        val values = listOf(
            1000 to "M",
            900 to "CM",
            500 to "D",
            400 to "CD",
            100 to "C",
            90 to "XC",
            50 to "L",
            40 to "XL",
            10 to "X",
            9 to "IX",
            5 to "V",
            4 to "IV",
            1 to "I"
        )

        var remaining = n
        var roman = ""

        for ((value, symbol) in values) {
            while (remaining >= value) {
                roman += symbol
                remaining -= value
            }
        }

        return roman
    }
}
