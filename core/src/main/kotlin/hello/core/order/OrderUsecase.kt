package hello.core.order

interface OrderUsecase {
    fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order
}