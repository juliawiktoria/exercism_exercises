object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> {
        val flattenedList = mutableListOf<Any>()

        for (element in source) {
            when (element) {
                is List<*> -> flattenedList.addAll(flatten(element as List<Any>))
                else -> if (element != null) flattenedList.add(element)
            }
        }

        return flattenedList
    }
}
