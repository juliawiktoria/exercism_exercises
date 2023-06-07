
import kotlin.math.ceil
import kotlin.math.sqrt
object CryptoSquare {
    fun ciphertext(plaintext: String): String {
        val normalized = plaintext.filter { it.isLetterOrDigit() }.toLowerCase().also { if (it.isEmpty()) return "" }
        val numCols = ceil(sqrt(normalized.length.toDouble())).toInt()
        return normalized.chunked(numCols).let { sq ->
            (0 until numCols).joinToString(" ") { i -> sq.map { it.getOrNull(i) ?: ' ' }.joinToString("")  }
        }
    }
}
