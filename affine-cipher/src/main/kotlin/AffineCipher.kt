import java.math.BigInteger
object AffineCipher {
    private val alphabet = ('a'..'z').toList()
    private val m = alphabet.size
    private val String.ordinal: Int
        get() = alphabet.indexOf(this[0].toLowerCase())

    private val Int.letter: String
        get() = "${alphabet[this]}"

    private infix fun Int.floorMod(m: Int) = (this % m + m) % m   // Or just use Math.floorMod(this, m)

    private fun Int.modInverse(m: Int) = BigInteger.valueOf(this.toLong()).modInverse(BigInteger.valueOf(m.toLong())).toInt()

    private fun String.transform(a: Int, transform: (Int) -> Int) = this.filter { it.isLetterOrDigit() }.let { input ->

        fun isCoprime(a: Int, m: Int): Boolean {
            fun gcd(a: Int, m: Int): Int = when (m == 0) {
                true -> a
                false -> gcd(m, a % m)
            }
            return gcd(a, m) == 1
        }

        require(isCoprime(a, m)) {"Error: a and m must be coprime." }
        input.replace(Regex("$alphabet", RegexOption.IGNORE_CASE)) {
            transform(it.value.ordinal).letter
        }
    }

    fun encode(input: String, a: Int, b: Int) = input.transform(a) { x ->
        (a * x + b) % m
    }
        .chunked(5).joinToString(" ")

    fun decode(input: String, a: Int, b: Int) = input.transform(a) { x ->
        a.modInverse(m) * (x - b) floorMod m
    }
}
