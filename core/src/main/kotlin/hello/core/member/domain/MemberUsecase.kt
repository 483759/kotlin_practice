package hello.core.member.domain

interface MemberUsecase {
    fun join(member: Member)
    fun findMember(memberId: Long): Member
}