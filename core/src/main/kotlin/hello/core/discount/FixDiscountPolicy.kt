package hello.core.discount

import hello.core.member.domain.Grade
import hello.core.member.domain.Member

class FixDiscountPolicy : DiscountPolicy {

    companion object {
        const val discountAmount = 1000
    }

    override fun discount(member: Member, price: Int): Int = if (member.grade == Grade.VIP) discountAmount else 0
}