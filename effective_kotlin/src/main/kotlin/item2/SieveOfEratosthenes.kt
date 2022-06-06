package item2

fun main() {
    simpleExample()
    sequenceExample()
    sequenceBadExample()
}

fun simpleExample() {
    var numbers = (2..30).toList()
    val primes = mutableListOf<Int>()
    while (numbers.isNotEmpty()) {
        val prime = numbers.first()
        primes.add(prime)
        numbers = numbers.filter { it % prime != 0 }
    }
    println(primes)
    // [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]
}

fun sequenceExample() {
    val primes: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1 }

        while (true) {
            val prime = numbers.first()
            yield(prime)
            numbers = numbers.drop(1).filter { it % prime != 0 }
        }
    }
    println(primes.take(10).toList())
    // [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]
}

fun sequenceBadExample() {
    val primes: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1 }

        var prime: Int
        while (true) {
            prime = numbers.first()
            yield(prime)
            numbers = numbers.drop(1).filter { it % prime != 0 }
        }
    }
    println(primes.take(10).toList())
    // [2, 3, 5, 6, 7, 8, 9, 10, 11, 12]
}
