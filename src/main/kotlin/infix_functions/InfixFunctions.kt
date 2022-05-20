package infix_functions

/**Kotlin allows some functions to be called without using the period and brackets. These are called infix methods, and their use can result in code that looks much more like a natural language.*/

fun main() {
    val value = 12 isEqual 25
    val value2 = 12 isEqual 12
    println(value2)
}

infix fun Int.isEqual(otherValue:Int) = this == otherValue