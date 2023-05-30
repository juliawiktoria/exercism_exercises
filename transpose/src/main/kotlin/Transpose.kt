object Transpose {

    fun transpose(input: List<String>): List<String> {
        val row: Int = input.maxOfOrNull { it.length } ?: 0
        var result = Array<String>(row) { "" }

        for(i in 0 until row){
            val col = input.indexOfLast { it.length > i }
            for(j in 0..col){
                result[i] += input[j].elementAtOrElse(i) { ' ' }.toString()
            }
        }
        return result.toList()
    }
}
