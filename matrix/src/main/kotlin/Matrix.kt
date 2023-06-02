class Matrix(private val matrixAsString: String) {
    val datas: List<List<Int>>
    init {
        datas = matrixAsString
            .replace("[ ]+".toRegex(), " ")
            .split("\n")
            .map {
                it.trim().split(" ").map { it.toInt() }
            }
    }
    fun column(colNr: Int): List<Int> {
        return datas.map { it[colNr - 1] }
    }
    fun row(rowNr: Int): List<Int> {
        return datas.get(rowNr - 1)
    }
}
