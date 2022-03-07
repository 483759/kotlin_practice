package hello.core.member.application

import hello.core.member.domain.Grade
import hello.core.member.domain.Member
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MemberServiceTest {

    val memberUsecase = MemberService()

    @Test
    fun join() {
        val member = Member(1L, "binary", Grade.VIP)

        memberUsecase.join(member)
        val findMember = memberUsecase.findMember(1L)

        assertEquals(findMember, member)
    }

    @Test
    fun findMember() {
    }
}