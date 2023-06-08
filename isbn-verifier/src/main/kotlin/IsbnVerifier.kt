fun Char.toInteger() = if(this == 'X') 10 else this.toString().toInt()
class IsbnVerifier {
    fun isValid(test : String) =
        test.matches(Regex("[0-9]-?[0-9]{3}-?[0-9]{5}-?[0-9X]")) &&
                test.replace(Regex("[^0-9X]"), "")
                    .mapIndexed { index, c -> c.toInteger() * (index + 1) }
                    .sum()
                    .rem(11) == 0
}