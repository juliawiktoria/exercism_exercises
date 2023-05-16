object ResistorColor {

    fun colorCode(input: String): Int {
        return this.colors().indexOf(input)
    }

    fun colors(): List<String> {
        return listOf("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white")
    }

}
