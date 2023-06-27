object Atbash {
    private val MAPPINGS = (('a'..'z').zip('z'.downTo('a')) + ('0'..'9').zip('0'..'9')).toMap()
    fun encode(input: String) =
        input.toLowerCase().replace("[^a-z0-9]".toRegex(), "")
            .translate()
            .chunked(5)
            .joinToString(" ")
    fun decode(input: String) = input.replace(" ", "").translate()
    private fun String.translate() = this.fold(StringBuilder()) { sb, c -> sb.append(MAPPINGS[c]) }.toString()
}
