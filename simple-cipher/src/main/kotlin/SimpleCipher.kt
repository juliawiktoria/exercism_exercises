import kotlin.random.Random
const val BASE_START = 'a'
const val BASE_END = 'z'
const val BASE_SIZE = (BASE_END - BASE_START + 1)
const val RANDOM_KEY_SIZE = 100
data class Cipher(val key: String = getRandomKey()) {
    companion object {
        private fun getRandomKey() =
            List(RANDOM_KEY_SIZE) { (Random.nextInt(0, BASE_SIZE)).toCharFromBase() }
                .joinToString("")
        private fun Char.toBaseIndex() = this.code - BASE_START.code
        private fun Int.toCharFromBase(): Char {
            var ret = this
            while (ret < 0) ret += BASE_SIZE
            ret %= BASE_SIZE
            ret += BASE_START.code
            return ret.toChar()
        }
    }
    private val shiftDistances = key.map { it.toBaseIndex() }
    init {
        require(shiftDistances.isNotEmpty()) { "Key cannot be empty" }
        require(shiftDistances.all { it >= 0 && it < BASE_SIZE }) { "Illegal character in key" }
    }
    fun encode(s: String): String {
        val originalChars = s.toCharArray()
        val encodedChars =
            originalChars.mapIndexed { index, char ->
                (char.toBaseIndex() + shiftDistances[index % shiftDistances.size])
                    .toCharFromBase()
            }
        return encodedChars.joinToString("")
    }
    fun decode(s: String): String {
        val originalChars = s.toCharArray()
        val encodedChars =
            originalChars.mapIndexed { index, char ->
                (char.toBaseIndex() - shiftDistances[index % shiftDistances.size])
                    .toCharFromBase()
            }
        return encodedChars.joinToString("")
    }
}