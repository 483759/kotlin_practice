package hello.core.discount

import hello.core.member.domain.Member

interface DiscountPolicy {
    fun discount(member: Member, price: Int): Int
}