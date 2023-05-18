import kotlin.math.pow

object ResistorColorTrio {

    fun text(vararg input: Color): String {
        val number = "${input[0].ordinal}${input[1].ordinal}${"0".repeat(input[2].ordinal)}".toInt()
        val level = (number.toString().length - 1) / 3
        val trimmedValue = number / 1_000.0.pow(level)
        val unit = Unit.values()[level].name
        return "${trimmedValue.toInt()} ${unit.toLowerCase()}"
    }
}
