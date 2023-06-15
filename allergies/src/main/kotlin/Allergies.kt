class Allergies(score: Int) {
    private val allergies = mutableListOf<Allergen>()
    init {
        Allergen.values().filterTo(allergies) { it.score and score > 0 }
    }
    fun isAllergicTo(allergen: Allergen) = allergies.contains(allergen)
    fun getList(): List<Allergen> = allergies.toList()
}