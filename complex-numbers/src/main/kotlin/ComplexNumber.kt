import kotlin.math.*

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {
    val abs = sqrt(real * real + imag * imag)
}

fun ComplexNumber.conjugate() = ComplexNumber(this.real, -this.imag)

fun exponential(c: ComplexNumber): ComplexNumber = c.let { (a, b) ->
    if (a == 0.0)
        ComplexNumber(cos(b), sin(b))
    else
        ComplexNumber(E.pow(a)) * exponential(ComplexNumber(imag=b))
}

operator fun ComplexNumber.times(other: ComplexNumber): ComplexNumber {
    val (a, b, c, d) = t4(this, other)
    return ComplexNumber(a * c - b * d, b * c + a * d)
}

operator fun ComplexNumber.plus(other: ComplexNumber): ComplexNumber {
    val (a, b, c, d) = t4(this, other)
    return ComplexNumber(a + c, b + d)
}

operator fun ComplexNumber.minus(other: ComplexNumber): ComplexNumber {
    val (a, b, c, d) = t4(this, other)
    return ComplexNumber(a - c, b - d)
}

operator fun ComplexNumber.div(other: ComplexNumber): ComplexNumber {
    val (a, b, c, d) = t4(this, other)
    return ComplexNumber(
        (a * c + b * d) / (c * c + d * d),
        (b * c - a * d) / (c * c + d * d))
}

private data class Tuple4(
    val a: Double,
    val b: Double,
    val c: Double,
    val d: Double)

private fun t4(x: ComplexNumber, y: ComplexNumber): Tuple4 {
    val (a, b) = x
    val (c, d) = y
    return Tuple4(a, b, c, d)
}
