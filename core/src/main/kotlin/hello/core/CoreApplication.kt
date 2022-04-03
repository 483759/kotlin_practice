package hello.core

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class CoreApplication

fun main(args: Array<String>) {
	runApplication<CoreApplication>(*args)
	// Start().play()
}
//
// class Start() {
//
// 	@Autowired
// 	private lateinit var adaptor1: Adaptor1
//
// 	fun play() {
// 		println(adaptor1.foo())
// 	}
// }
//
// interface Port {
// 	fun foo(): String
// }
//
// @Component
// class Adaptor1: Port {
// 	override fun foo(): String = "I'm Adaptor 1"
// }
//
// @Component
// class Adaptor2: Port {
// 	override fun foo(): String = "I'm Adaptor 2"
// }
