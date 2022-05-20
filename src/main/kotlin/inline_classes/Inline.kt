package inline_classes

/**
 * An inline function is declare with a keyword inline. The use of inline function enhances the performance of higher order function. The inline function tells the compiler to copy parameters and functions to the call site*/
fun main(args: Array<String>) {
//    inlineFunction { println("calling inline functions 1") }

    //Non-local control flow
//    inlineFunction2({ println("calling inline functions 2")return},{ println("next parameter in inline functions 2")})

    //Non-return control flow
//    inlineFunction3({ println("calling inline functions 3")},{ println("next parameter in inline functions 3")})

    //Non-return control flow
//    inlineFunction3({ println("calling inline functions 3")},{ println("next parameter in inline functions 3")})

    //Non-inline second function is accepted in second parameter
    inlineFunction4({ println("calling inline functions 4")}, { test {println("next parameter in inline functions 4") } })
}

inline fun test(myStr: () -> Unit){
    myStr()
    println("Inside inline test")
}

inline fun inlineFunction(myFun: () -> Unit ) {
    myFun()
    println("code inside inline function 1")
}

/**From inline function, we can return from lambda expression itself. This will also lead to exit from the function in which inline function was called. The function literal is allowed to have non local return statements in such case.*/
inline fun inlineFunction2(myFun: () -> Unit, nxtFun: () -> Unit) {
    myFun()
    nxtFun()
    println("code inside inline function 2")
}

inline fun inlineFunction3(crossinline myFun: () -> Unit, nxtFun: () -> Unit) {
    myFun()
    nxtFun()
    println("code inside inline function 3")
}

/**NoInline as nxtFun will not accept inline functions*/
inline fun inlineFunction4(crossinline myFun: () -> Unit, noinline nxtFun: () -> Unit) {
    myFun()
    nxtFun()
    println("code inside inline function 4")
}