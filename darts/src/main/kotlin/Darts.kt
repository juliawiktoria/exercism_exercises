object Darts {

    fun score(x: Number, y: Number): Int {
        val distance = Math.sqrt(x.toDouble() * x.toDouble() + y.toDouble() * y.toDouble())

        if (distance <= 1) return 10
        if (distance <= 5) return 5
        if (distance <= 10) return 1
        return 0
    }
}
