package io.wisoft.daewon.member

import org.springframework.stereotype.Service

@Service
class MemberService(private val memberRepository: MemberRepository) {
  fun findAll(): MutableList<Member> {
    return memberRepository.findAll()
  }

  fun findById(id: Long): Member? {
    return memberRepository.getOne(id)
  }

  fun findByEmail(email: String): Member? {
    return memberRepository.findByEmail(email)
  }

  fun updateMemberPoint(member: Member, id: Long): Long? {
    val target: Member = memberRepository.getOne(id)
    target.point = target.point?.plus(member.point!!)
    memberRepository.save(target)
    return target.point
  }

}