package com.example.blog

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class HttpControllersTests(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var userRepository: UserRepository

    @MockkBean
    private lateinit var articleRepository: ArticleRepository

    @Test
    fun `List articles`() {
        val binary = User("springbinary", "binary", "yun")
        val helloWorld = Article(
            title = "Hello World",
            headline = "I am foo",
            content = "Kotlin is difficult",
            author = binary
        )
        val helloBinary = Article(
            title = "Hello binary",
            headline = "^0^",
            content = "I am binary",
            author = binary
        )

        every { articleRepository.findAllByOrderByAddedAtDesc() } returns
            listOf(helloWorld, helloBinary)

        mockMvc.perform(get("/api/article/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].author.login").value(binary.login))
            .andExpect(jsonPath("\$.[0].slug").value(helloWorld.slug))
            .andExpect(jsonPath("\$.[1].author.login").value(binary.login))
            .andExpect(jsonPath("\$.[1].slug").value(helloBinary.slug))
    }

    @Test
    fun `List users`() {
        val binary = User("springbinary", "binary", "yun")
        val glass = User("springglass", "waterglass", "oh")

        every { userRepository.findAll() } returns listOf(binary, glass)

        mockMvc.perform(get("/api/user/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].login").value(binary.login))
            .andExpect(jsonPath("\$.[1].login").value(glass.login))
    }
}