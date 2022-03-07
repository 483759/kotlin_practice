package hello.core.member.domain

interface FindMemberPort {
    fun findById(memberId: Long): Member?
}