class BaseConverter(val base: Int, val digits: IntArray) {
    init {
        require(base > 1) { "Bases must be at least 2." }
        require(digits.isNotEmpty()) { "You must supply at least one digit." }
        require(digits[0] != 0 || digits.size == 1) { "Digits may not contain leading zeros." }
        require(digits.all { it >= 0 }) { "Digits may not be negative." }
        require(digits.all { it < base }) { "All digits must be strictly less than the base." }
    }
    val value = digits.fold(0) { acc, v -> acc * base + v }
    fun convertToBase(newBase: Int, n: Int = value): IntArray {
        require(newBase > 1) { "Bases must be at least 2." }
        return if (n < newBase) intArrayOf(n)
        else convertToBase(newBase, n / newBase) + n % newBase
    }
}