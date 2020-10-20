package io.wisoft.daewon.member

import io.wisoft.daewon.exception.MemberAlreadyExistsException
import io.wisoft.daewon.exception.MemberInfoIncorrectException
import org.springframework.stereotype.Service

@Service
class AuthService(private val memberRepository: MemberRepository) {

  fun login(member: Member): Member {
    return memberRepository.findByEmailAndPassword(member.email!!, member.password!!) ?: throw MemberInfoIncorrectException(message = "이메일 또는 비밀번호가 틀렸습니다.")
  }

  fun signUp(member: Member): Member {
    if (memberRepository.existsByEmail(member.email!!)) throw MemberAlreadyExistsException(message = "이미 존재하는 이메일입니다.")
    return memberRepository.save(member)
  }

}