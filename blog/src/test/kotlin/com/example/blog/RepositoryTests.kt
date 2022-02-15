package com.example.blog

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull
import javax.transaction.Transactional

@DataJpaTest
class RepositoryTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserRepository,
    val articleRepository: ArticleRepository
) {

    @Test
    @Transactional
    fun `When findByIdOrNull then return Article`() {
        val binary = User("springbinary", "binary", "yun")
        entityManager.persist(binary)

        val article = Article("Spring Boot and Kotlin is difficult", "I'm foo", "I want money", binary)
        entityManager.persist(article)  // 이거 오타나서 binary로 해봤는데, 아래에 id 필드 접근하는 부분에서 NPE발생
                                        // @GeneratedValue로 생성되는 시점은 flush 되고 나서부터 인듯
        entityManager.flush()

        val found = articleRepository.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }

    @Test
    @Transactional
    fun `When findByLogin then return User`() {
        val binary = User("springbinary", "binary", "yun")

        entityManager.persist(binary)
        entityManager.flush()

        val user = userRepository.findByLogin(binary.login)
        assertThat(user).isEqualTo(binary)
    }
}