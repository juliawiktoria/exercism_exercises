object PigLatin {
    fun translate(input: String): String {
        return input.split(" ").joinToString(" ") {
            val cluster = getCluster(it)
            (if (cluster.isEmpty()) it else it.drop(cluster.length).plus(cluster)).plus("ay")
        }
    }
    private fun getCluster(input: String): String {
        return Regex("^y[aeiouy]").find(input)?.value?.get(0)?.toString() ?: // I do not understand this rule, it is not in the exercise rules
        Regex("^[^aeiouy]*qu+").find(input)?.value ?:
        Regex("^[^xaeiouy]+").find(input)?.value ?:
        Regex("^x[aeiouy]+").find(input)?.value?.get(0)?.toString() ?:
        ""
    }
}