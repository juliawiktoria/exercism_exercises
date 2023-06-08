class RotationalCipher(private val key: Int) {

    fun encode(text: String): String {
        return text.map { char ->
            when {
                char.isLetter() -> rotateChar(char, key)
                else -> char
            }
        }.joinToString("")
    }

    private fun rotateChar(char: Char, key: Int): Char {
        val alphabetSize = 26
        val isUpperCase = char.isUpperCase()

        val normalizedChar = char.lowercaseChar()
        val rotatedChar = ((normalizedChar - 'a' + key) % alphabetSize + 'a'.code).toChar()

        return if (isUpperCase) rotatedChar.uppercaseChar() else rotatedChar
    }
}
