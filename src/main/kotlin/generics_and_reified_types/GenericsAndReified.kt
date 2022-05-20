package generics_and_reified_types

fun main() {
    //as there is no data to infer type of class to class name is required
    genericsExample(String::class.java,"Working")
    genericsExample(Int::class.java,1)

    println("\n")

    //as there is data to infer type of class
    genericsExample("Working refied")
    genericsExample(2)
}

//without refied
fun <T> genericsExample(classType: Class<T>, value: T) {
    println(value)
    println("Type of T: $classType")
}

inline fun <reified T> genericsExample(value: T) {
    println(value)
    println("Type of T: ${T::class.java}")
}