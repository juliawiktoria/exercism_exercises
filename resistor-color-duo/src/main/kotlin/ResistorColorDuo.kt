object ResistorColorDuo {

    fun value(vararg colors: Color): Int {
        val result = mutableListOf<String>()

        for (i in 0..1) {
            result.add(colors[i].ordinal.toString())
        }

        return result.joinToString("").toInt()
    }
}
