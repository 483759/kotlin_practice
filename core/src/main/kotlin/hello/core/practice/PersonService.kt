package hello.core.practice

import net.sf.cglib.proxy.Enhancer
import net.sf.cglib.proxy.FixedValue

class PersonService {
    fun sayHello(name: String): String = "Hello $name"
    fun lengthOfName(name: String): Int = name.length
}

fun main() {
    val enhancer = Enhancer()
    enhancer.setSuperclass(PersonService::class.java)
    // enhancer.setCallback((FixedValue) () -> "Hello Binary")
}