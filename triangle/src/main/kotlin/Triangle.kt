class Triangle(val side1Length: Double, val side2Length: Double, val side3Length: Double) {
    constructor(side1Length: Int, side2Length: Int, side3Length: Int):
            this(side1Length.toDouble(), side2Length.toDouble(), side3Length.toDouble())
    init {
        val sideLengths = listOf(side1Length, side2Length, side3Length)
        require(sideLengths.all { it > 0 } && sideLengths.all { sideLengths.minus(it).sum() >= it })
    }
    private val uniqueSideLengths = setOf(side1Length, side2Length, side3Length)
    val isEquilateral = uniqueSideLengths.size == 1
    val isIsosceles = uniqueSideLengths.size <= 2
    val isScalene = uniqueSideLengths.size == 3
}
