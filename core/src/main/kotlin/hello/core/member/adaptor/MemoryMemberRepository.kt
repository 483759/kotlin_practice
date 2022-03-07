package hello.core.member.adaptor

import hello.core.member.domain.FindMemberPort
import hello.core.member.domain.Member
import hello.core.member.domain.SignUpMemberPort

class MemoryMemberRepository : SignUpMemberPort, FindMemberPort {
    companion object {
        val store: HashMap<Long, Member> = HashMap()
    }

    override fun findById(memberId: Long): Member?{
        return store[memberId]
    }

    override fun save(member: Member) {
        store[member?.id] = member
    }
}