object ETL {
    fun transform(old: Map<Int, List<Char>>): Map<Char, Int> {
        return old.flatMap({ (k, v) -> v.map { it.toLowerCase() to k } }).toMap()
    }
}