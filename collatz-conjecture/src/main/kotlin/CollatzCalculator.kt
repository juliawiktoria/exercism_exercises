object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        if (start < 1) throw IllegalArgumentException()
        if (start == 1) return 0
        var number = start
        var steps = 0

        while (number != 1) {
            steps++
            if (number % 2 == 0) {
                number = number / 2
            } else {
                number = 3 * number + 1
            }
        }

        return steps
    }
}
