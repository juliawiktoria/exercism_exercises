data class Year(val year: Int) {

    val isLeap: Boolean = this.year % 4 == 0 && (this.year % 100 != 0 || this.year % 400 == 0)
}
