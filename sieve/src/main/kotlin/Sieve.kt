object Sieve {
    fun primesUpTo(n: Int): List<Int> {
        var primes = (2 .. n).toList()
        primes.forEach { primes -= ((it + it) .. n step it).toList() }
        return primes
    }
}