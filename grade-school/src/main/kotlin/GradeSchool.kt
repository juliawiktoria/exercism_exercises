class School {
    private val students = mutableMapOf<Int, MutableList<String>>()
    fun add(student: String, grade: Int) = students.getOrPut(grade) { mutableListOf() }.add(student)
    fun grade(grade: Int): List<String> = students[grade]?.sorted() ?: emptyList()
    fun roster(): List<String> = students.toList().sortedBy { it.first }.flatMap { it.second.sorted() }
}