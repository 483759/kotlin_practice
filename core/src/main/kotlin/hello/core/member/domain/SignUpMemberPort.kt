package hello.core.member.domain

interface SignUpMemberPort {
    fun save(member: Member)
}