object Bob {
    fun hey(input: String): String {
        val prompt = input.replace("\\s".toRegex(), "")
        return when {
            prompt.isYelling() && prompt.isQuestion() -> "Calm down, I know what I'm doing!"
            prompt.isYelling() -> "Whoa, chill out!"
            prompt.isQuestion() -> "Sure."
            prompt.isSilence() -> "Fine. Be that way!"
            else -> "Whatever."
        }
    }

    private fun String.isQuestion(): Boolean = endsWith("?")
    private fun String.isSilence(): Boolean = isBlank()
    private fun String.isYelling(): Boolean {
        return !letters().isSilence() and letters().isUpperCase()
    }
    private fun String.isUpperCase(): Boolean  = all(Char::isUpperCase)
    private fun String.letters(): String  = filter(Char::isLetter)
}
