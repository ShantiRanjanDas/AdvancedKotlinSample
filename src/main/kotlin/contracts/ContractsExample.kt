package contracts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

fun main() {

    //as we have to use ? everywhere when we use name, as it can be null
    val name: String? = null
    if(name.isNull) return

    println("name is ${name?.length ?: 0} characters long")

    val name2: String? = null
    if(name.isNull2()) return

    //as we can clearly see that there is no need for ? now as we already checked, it will not be null
    //if its reaches this line with contracts
    println("name is ${name.length} characters long")
}

val Any?.isNull: Boolean get() = this == null

@OptIn(ExperimentalContracts::class)
fun Any?.isNull2(): Boolean {
    contract {
        returns(false) implies (this@isNull2 != null)
    }
    return this == null
}