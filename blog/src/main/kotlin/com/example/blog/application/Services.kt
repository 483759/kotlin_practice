package com.example.blog.application

import com.example.blog.ArticleRepository
import com.example.blog.User
import com.example.blog.UserRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(private val repository: ArticleRepository) {

    fun findAll() = repository.findAllByOrderByAddedAtDesc()

    fun findOneBySlug(slug: String) =
        repository.findBySlug(slug) ?: throw
            IllegalArgumentException("This article does not exist")
}

@Service
class UserService(private val repository: UserRepository) {

    fun findAll(): Iterable<User> = repository.findAll()

    fun findOneByLogin(login: String) =
        repository.findByLogin(login) ?: throw
            IllegalArgumentException("This user does not exist")
}