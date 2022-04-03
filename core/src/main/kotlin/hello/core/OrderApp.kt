package hello.core

import hello.core.member.application.MemberService
import hello.core.member.domain.Grade
import hello.core.member.domain.Member
import hello.core.order.OrderService

fun main() {
    val memberService = MemberService()
    val orderService = OrderService()

    val memberId = 1L
    val member = Member(memberId, "memberA", Grade.VIP)
    memberService.join(member)

    val order = orderService.createOrder(memberId, "itemA", 10000);

    println("order = $order")
    println("order.calculatePrice = ${order.calculatePrice()}")
}
