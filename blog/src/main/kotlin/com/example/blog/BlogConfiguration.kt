package com.example.blog

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(userRepository: UserRepository,
    articleRepository: ArticleRepository) = ApplicationRunner {
        val binary = userRepository.save(User("springbinary", "binary", "yun"))
        articleRepository.save(Article(
            title = "Hello World",
            headline = "I am foo",
            content = "Kotlin is difficult",
            author = binary
        ))
        articleRepository.save(Article(
            title = "Hello binary",
            headline = "^0^",
            content = "I am binary",
            author = binary
        ))
    }
}