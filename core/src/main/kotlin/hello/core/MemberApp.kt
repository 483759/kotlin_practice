package hello.core

import hello.core.member.application.MemberService
import hello.core.member.domain.Grade
import hello.core.member.domain.Member

fun main() {
    val memberUsecase = MemberService()
    val member = Member(1L, "binary", Grade.VIP)
    memberUsecase.join(member)

    val findMember = memberUsecase.findMember(1L)
    println("new member: $member")
    println("findMember: $findMember")
}