package lambdas_with_receiver

fun main() {
    println(myHigherOrderFun { "Hello" })

    val greet: String.() -> Unit = { println("Hello, $this") }
    greet("This is how it works?")

    val msg = StringBuffer("Working ").apply {
        append("as I am expecting.")
        append("...!")
    }
    println(msg)
}

fun myHigherOrderFun(functionArg: (Int)->String) = functionArg(5)

public inline fun <T> T.apply(block: T.() -> Unit): T { block(); return this }