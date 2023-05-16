object Pangram {
    val letters: List<Char> = ('a'..'z').toList()

    fun isPangram(input: String): Boolean {

        if (input.length == 0) return false

        for (item: Char in this.letters) {
            if (!(item in input.lowercase())) {
                return false
            }
        }
        return true
    }
}
