package operator_overloading

fun main() {
    val fraction = Fraction(2,3) + Fraction(3, 2)
    println(fraction.decimal)

    val compareResult = Fraction(2,3) > Fraction(3, 2)
    println(compareResult)
}

data class Fraction(val numerator: Int, val denominator: Int) {
    val decimal by lazy { numerator.toDouble() / denominator }

    override fun toString() = "$numerator/$denominator"

    operator fun plus(add: Fraction) =
        if (this.denominator == add.denominator)
            Fraction(this.numerator + add.numerator, denominator)
        else {
            val a: Fraction = this * add.denominator
            val b: Fraction = add * this.denominator
            Fraction(a.numerator + b.numerator, a.denominator)
        }

    operator fun times(num: Int) = Fraction(numerator * num,denominator * num)

    operator fun compareTo(other: Fraction) = decimal.compareTo(other.decimal)
}