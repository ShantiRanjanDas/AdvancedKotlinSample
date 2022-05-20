package delegated_properties

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**A “Delegate” is just a class that provides the value of a property and handles its changes. This will help us to delegate(assign or pass on), the getter-setter logic altogether to a different class so that it can help us in reusing the code.*/
fun main() {
    str = "Checking"
    println(str)

    var trimmedString:String by TrimDelegate()
    trimmedString = "New VALUE "
    println(trimmedString)

    println(max)
    max = 10
    println(max)
    max = 5
    println(max)

}

var str:String=""
    set(value) {
        field = "${value.trim()} is a String!"
    }

//getting max by vetoable
var max: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
    newValue > oldValue
}

class TrimDelegate{
    private var trimAppendedString = ""

    operator fun getValue(nothing: Nothing?, property: KProperty<*>) = trimAppendedString

    operator fun setValue(nothing: Nothing?, property: KProperty<*>, value: String) {
        trimAppendedString = "${value.trim()} is a String!"
    }

}


