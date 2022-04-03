package hello.core.discount

import hello.core.member.domain.Grade
import hello.core.member.domain.Member

class RateDiscountPolicy: DiscountPolicy {

    companion object {
        private const val discountPolicy = 10
    }

    override fun discount(member: Member, price: Int): Int {
        if (member.grade == Grade.VIP)
            return price * discountPolicy / 100
        return 0
    }
}