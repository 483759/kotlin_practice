package com.example.blog.adaptor.web

import com.example.blog.Article
import com.example.blog.User
import com.example.blog.application.ArticleService
import com.example.blog.application.UserService
import com.example.blog.config.format
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/article")
class ArticleController(private val service: ArticleService) {

    @GetMapping("/")
    fun findAll() = ResponseEntity.ok(service.findAll())

    @GetMapping("/{slug}")
    fun findOne(@PathVariable slug: String): ResponseEntity<RenderedArticle> {
        val article = try {
            service.findOneBySlug(slug)
        } catch (e: IllegalArgumentException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, e.message)
        }

        val renderedArticle = article.render()
        return ResponseEntity.ok().body(renderedArticle)
    }
}

@RestController
@RequestMapping("/api/user")
class UserController(private val service: UserService) {

    @GetMapping("/")
    fun findAll(): Iterable<User> = service.findAll()

    @GetMapping("/{login}")
    fun findOne(@PathVariable login: String) {
        try {
            service.findOneByLogin(login)
        } catch (e: IllegalArgumentException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, e.message)
        }
    }
}

fun Article.render() = RenderedArticle(
    title, headline, content, RenderedUser(author.login), addedAt.format()
)

data class RenderedArticle(
    val title: String,
    val headline: String,
    val content: String,
    val author: RenderedUser,
    val addedAt: String
)

data class RenderedUser(
    val login: String
)