package item2

fun main() {
    var users = listOf("binary", "yun", "ijin")

    var user: String
    for (i in users.indices) {      // bad example
        user = users[i]
        println("User at $i is $user")
    }

    for (i in users.indices) {      // good example
        val user = users[i]
        println("User at $i is $user")
    }

    for ((i, user) in users.withIndex()) {  // best example
        println("User at $i is $user")
    }
}