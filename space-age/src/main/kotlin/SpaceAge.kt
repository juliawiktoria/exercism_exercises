class SpaceAge(private val ageInSeconds: Long) {
    private val earthOrbitalPeriodInSeconds = 31557600.0

    fun onEarth(): Double = calculateAgeOnPlanet(1.0)
    fun onMercury(): Double = calculateAgeOnPlanet(0.2408467)
    fun onVenus(): Double = calculateAgeOnPlanet(0.61519726)
    fun onMars(): Double = calculateAgeOnPlanet(1.8808158)
    fun onJupiter(): Double = calculateAgeOnPlanet(11.862615)
    fun onSaturn(): Double = calculateAgeOnPlanet(29.447498)
    fun onUranus(): Double = calculateAgeOnPlanet(84.016846)
    fun onNeptune(): Double = calculateAgeOnPlanet(164.79132)

    private fun calculateAgeOnPlanet(orbitalPeriod: Double): Double {
        val ageInYears = ageInSeconds / (earthOrbitalPeriodInSeconds * orbitalPeriod)
        return "%.2f".format(ageInYears).toDouble()
    }
}
