package io.wisoft.daewon.member
//
//import io.wisoft.daewon.member.QMember.member
//import kotlinx.coroutines.selects.select
//import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
//
//class MemberRepositoryImpl() : QuerydslRepositorySupport(Member::class.java), MemberRepositoryCustom {
//  override fun getMemberAll(): List<Member> {
//    return from(member).fetch()
//  }
//
//  override fun getMemberByEmail(email: String): Member? {
//    return from(member).where(member.email.gt(email)).fetchOne()
//  }
//}