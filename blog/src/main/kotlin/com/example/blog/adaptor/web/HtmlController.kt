package com.example.blog.adaptor.web

import com.example.blog.Article
import com.example.blog.User
import com.example.blog.application.ArticleService
import com.example.blog.config.BlogProperties
import com.example.blog.config.format
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException

@Controller
class HtmlController(
    private val articleService: ArticleService,
    private val properties: BlogProperties
) {

    @GetMapping("/")
    fun blog(model: Model): String {
        model["title"] = "Blog"
        model["banner"] = properties.banner
        model["articles"] = articleService.findAll().map { it.render() }

        return "blog"
    }

    @GetMapping("/article/{slug}")
    fun article(@PathVariable slug: String, model: Model): String {
        val article = try {
            articleService
                .findOneBySlug(slug)
                ?.render()
        } catch (e: IllegalArgumentException) {
           throw ResponseStatusException(HttpStatus.NOT_FOUND, e.message)
        }

        model["title"] = article.title
        model["article"] = article

        return "article"
    }

    fun Article.render() = RenderedArticle(
        slug, title, headline, content, author, addedAt.format()
    )

    data class RenderedArticle(
        val slug: String,
        val title: String,
        val headline: String,
        val content: String,
        val author: User,
        val addedAt: String
    )
}