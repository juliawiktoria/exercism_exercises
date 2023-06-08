class BankAccount {
    private var closed = false
    private var realBalance = 0
    val balance: Int
        get() {
            synchronized(this) {
                check(!closed) { "account is closed" }
                return realBalance
            }
        }
    fun adjustBalance(delta: Int) {
        synchronized(this) {
            check(!closed) { "account is closed" }
            realBalance += delta
        }
    }
    fun close() {
        synchronized(this) {
            closed = true
        }
    }
}