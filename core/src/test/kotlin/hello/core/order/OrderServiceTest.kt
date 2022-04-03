package hello.core.order

import hello.core.member.application.MemberService
import hello.core.member.domain.Grade
import hello.core.member.domain.Member
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class OrderServiceTest {

    val memberService = MemberService()
    val orderService = OrderService()

    @Test
    fun getDiscountPolicy() {
    }

    @Test
    fun createOrder() {
        val memberId = 1L
        val member = Member(memberId, "memberA", Grade.VIP)
        memberService.join(member)

        val order = orderService.createOrder(memberId, "itemA", 10000)
        Assertions.assertThat(order.discountPrice).isEqualTo(1000)
    }
}