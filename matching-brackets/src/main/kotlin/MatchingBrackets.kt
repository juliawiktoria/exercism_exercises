object MatchingBrackets {
    private val openingBrackets = listOf('(', '[', '{')
    private val closingBrackets = listOf(')', ']', '}')
    private val bracketPairs = mapOf(')' to '(', ']' to '[', '}' to '{')

    fun isValid(input: String): Boolean {
        val stack = mutableListOf<Char>()

        for (char in input) {
            if (openingBrackets.contains(char)) {
                stack.add(char)
            } else if (closingBrackets.contains(char)) {
                if (stack.isEmpty() || stack.last() != bracketPairs[char]) {
                    return false
                } else {
                    stack.removeAt(stack.size - 1)
                }
            }
        }

        return stack.isEmpty()
    }
}
