import java.lang.Exception
object Wordy {
    private val regex = ("What is (-?[0-9]+)" +
            "( (plus|minus|divided by|multiplied by) (-?[0-9]+)" +
            "| raised to the [0-9]+th power)*[?]").toRegex()
    private val opRegex = "((plus|minus|divided by|multiplied by) (-?[0-9]+)|(raised to) the ([0-9])+th power)".toRegex()
    fun answer(input: String): Int {
        val init = regex.find(input)?.groupValues?.get(1)?.toInt() ?: throw Exception()
        val operations = opRegex.findAll(input).map(MatchResult::groupValues)
        return operations.fold(init) { acc, op ->
            when (op[2]) {
                "plus" -> acc + op[3].toInt()
                "minus" -> acc - op[3].toInt()
                "divided by" -> acc / op[3].toInt()
                "multiplied by" -> acc * op[3].toInt()
                else -> List(op.last().toInt()) { acc }.reduce(Int::times)
            }
        }
    }
}