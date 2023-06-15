object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        if (list.isEmpty()) throw NoSuchElementException()

        if(item < list.first() || item > list.last()) throw NoSuchElementException()

        var low = 0
        var high = list.size - 1

        while (low <= high) {
            val mid = (low + high) / 2

            when {
                list[mid] == item -> return mid
                list[mid] < item -> low = mid + 1
                else -> high = mid - 1
            }
        }

        throw NoSuchElementException()
    }
}
