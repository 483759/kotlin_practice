package hello.core.member.application

import hello.core.member.adaptor.MemoryMemberRepository
import hello.core.member.domain.Member
import hello.core.member.domain.MemberUsecase

class MemberService: MemberUsecase {

    val memberRepository = MemoryMemberRepository()

    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findMember(memberId: Long): Member {
        return memberRepository.findById(memberId)?:
        throw IllegalArgumentException("존재하지 않는 ID입니다")
    }
}