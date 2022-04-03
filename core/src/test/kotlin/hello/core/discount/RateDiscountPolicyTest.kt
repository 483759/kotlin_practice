package hello.core.discount

import hello.core.member.domain.Grade
import hello.core.member.domain.Member
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RateDiscountPolicyTest {

    val discountPolicy = RateDiscountPolicy()

    @Test
    fun `VIP는 10% 할인 적용`() {
        val member = Member(1L, "memberVIP", Grade.VIP)

        val discount = discountPolicy.discount(member, 10000)

        assertEquals(discount, 1000)
    }

    @Test
    fun `VIP가 아니면 할인 미적용`() {
        val member = Member(1L, "memberVIP", Grade.GENERAL)

        val discount = discountPolicy.discount(member, 10000)

        assertEquals(discount, 0)
    }
}