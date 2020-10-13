package io.wisoft.daewon.member

import org.springframework.stereotype.Service

@Service
class MemberService(private val memberRepository: MemberRepository) {
  fun findAll(): MutableIterable<Member> {
    return memberRepository.findAll()
  }

  fun findById(id: Long): Member? {
    return memberRepository.getOne(id)
  }

  fun findByEmail(email: String): Member? {
    return memberRepository.findByEmail(email)
  }

}