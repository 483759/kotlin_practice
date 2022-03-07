package hello.core.order

import hello.core.discount.FixDiscountPolicy
import hello.core.member.adaptor.MemoryMemberRepository

class OrderService: OrderUsecase {

    val memberRepository = MemoryMemberRepository()
    val discountPolicy = FixDiscountPolicy()

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val discount = memberRepository.findById(memberId)
            ?.let { discountPolicy.discount(it, itemPrice) }!!

        return Order(memberId, itemName, itemPrice, discount)
    }
}