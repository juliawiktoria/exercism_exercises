object BeerSong {
    fun verse(n: Int): String {
        require(n >= 0) { "Beer song verse can't be negative" }
        require(n < 100) { "Beer song only goes up to verse 99" }
        return when (n) {
            0 -> "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
            1 -> "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
            else -> "${bottles(n)} of beer on the wall, ${bottles(n)} of beer.\nTake one down and pass it around, ${bottles(n-1)} of beer on the wall.\n"
        }
    }
    fun verses(start: Int, end: Int) = (start downTo end).map { verse(it) }.joinToString("\n")
    val lyrics = verses(99, 0)
    private fun bottles(n: Int) = when (n) {
        1 -> "1 bottle"
        else -> "$n bottles"
    }
}
