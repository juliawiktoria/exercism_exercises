object PascalsTriangle {

    fun computeTriangle(rows: Int): List<List<Int>> {
        val triangle = mutableListOf<List<Int>>()

        for (row in 0 until rows) {
            val currentRow = mutableListOf<Int>()
            currentRow.add(1)

            for (col in 1 until row) {
                val value = triangle[row - 1][col - 1] + triangle[row - 1][col]
                currentRow.add(value)
            }

            if (row > 0) {
                currentRow.add(1)
            }

            triangle.add(currentRow)
        }

        return triangle
    }
}
