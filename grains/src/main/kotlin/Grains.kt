import java.math.BigInteger
object Board {
    private val squareNumber = 64
    fun getGrainCountForSquare(i: Int): BigInteger {
        require(i in 1..squareNumber) {
            "Only integers between 1 and 64 (inclusive) are allowed"
        }
        return BigInteger.valueOf(2).pow(i - 1)
    }
    fun getTotalGrainCount() = BigInteger.valueOf(2).pow(squareNumber) - BigInteger.ONE
}