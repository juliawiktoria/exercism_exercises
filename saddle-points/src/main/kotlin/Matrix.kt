data class Matrix(val rows: List<List<Int>>) {
    val saddlePoints: Set<MatrixCoordinate>
        get() {
            val saddlePoints = mutableSetOf<MatrixCoordinate>()

            for (rowIndex in rows.indices) {
                val row = rows[rowIndex]
                val maxInRow = row.maxOrNull()

                for (colIndex in row.indices) {
                    val value = row[colIndex]
                    if (value == maxInRow && isSmallestInColumn(colIndex, rowIndex)) {
                        saddlePoints.add(MatrixCoordinate(rowIndex + 1, colIndex + 1))
                    }
                }
            }

            return saddlePoints
        }

    private fun isSmallestInColumn(colIndex: Int, rowIndex: Int): Boolean {
        val value = rows[rowIndex][colIndex]
        val column = rows.map { it[colIndex] }
        val minInColumn = column.minOrNull()
        return value == minInColumn
    }
}

data class MatrixCoordinate(val row: Int, val col: Int)
